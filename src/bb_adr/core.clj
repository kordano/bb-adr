(ns bb-adr.core
  (:require [selmer.parser :refer [render-file]]
            [babashka.fs :as fs]))

(defn init [a-name]
  (prn (format "Hello %s!" (or (first a-name) "FOO"))))

(defn new [args]
  (let [title (or (first args) "FOO")
        filename (format "%s.md" title)
        adr-data {:number 1
                  :title title
                  :date (str (java.util.Date.))}]
    (spit filename
          (render-file (clojure.java.io/resource "adr_template.md") adr-data))))