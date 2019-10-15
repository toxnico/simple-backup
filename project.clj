(defproject simple-backup "0.1.0-SNAPSHOT"
  :description "A simple backup program running rsync in background"
  :url "https://github.com/toxnico/simple-backup"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/math.combinatorics "0.1.6"]]
  :repl-options {:init-ns simple-backup.core}
  :main simple-backup.core
  :aot :all)
