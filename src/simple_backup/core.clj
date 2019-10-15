(ns simple-backup.core
  (:require [clojure.math.combinatorics :as combo]
            [clojure.java.shell :as shell])
  (:gen-class))

(defn item->rsyncs
  "Generates a list of rsync commands from a backup item"
  [opt itm]
  (->> (combo/cartesian-product (:src itm) (:dst itm))
       (map (fn [p]
              ["rsync" opt (first p) (second p)]))))

(defn read-config-file
  "Read the configuration file and returns a clojure data structure"
  [path]
  (->> path
       (slurp)
       (read-string)))

(defn config->commands
  "transforms a configuration structure into a series of rsync commands"
  [cfg]
  (let [opt (:rsync-options cfg)]
    (->> (:items cfg)
         (map #(item->rsyncs opt %))
         (first))))

(defn -main
  [& args]

  (let [config-path (first args)
        cfg (read-config-file config-path)
        cmds (config->commands cfg)]
    (doseq [cmd cmds]

      (println cmd)
      (let [res (apply shell/sh cmd)]
        (println (:out res))
        (println (:err res)))

      (println "done"))
    (shutdown-agents)))
