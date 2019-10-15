# Simple Backup

A simple backup tool written in Clojure.
Uses rsync in background.

The configuration file allows you to define a set of source folders to be backed up into a set of destination folders.

## Usage

java -jar backup... path-to-config.edn

## Config file structure :
```clojure
{
 :rsync-options "-avt"
 :items [{:src ["/home/johndoe/documents" "/home/johndoe/bin"]
          :dst ["/path-to-backup-folder" "path-to-other-backup-folder"]}

         {:src ["/home/marilyn/Apps" "/home/marilyn/pictures"]
          :dst ["/path-to-backup-folder"]}]}
```


## License

Copyright © 2019 toxnico

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
