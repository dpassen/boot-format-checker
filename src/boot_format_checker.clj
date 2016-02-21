(ns boot-format-checker
  {:boot/export-tasks true}
  (:require [boot.core             :as boot :refer [deftask]]
            [boot.util             :as util]
            [cljfmt.core           :as cljfmt]
            [leiningen.cljfmt.diff :as diff]))

(defn print-diff
  [context-lines colorize? filename original revised]
  (let [diff (diff/unified-diff filename original revised context-lines)]
    (println (if colorize? (diff/colorize-diff diff) diff))))

(deftask check-formatting
  [c context  LINES int  "the number of lines of context."
   _ no-color       bool "Disable color output."]
  (boot/with-pre-wrap fileset
    (let [context          (or context 3)
          colorize?        (not no-color)
          clojure-files    (->> fileset boot/input-files (boot/by-ext [".clj" ".cljc" ".cljs"]))]
      (doseq [{:keys [path] :as file} clojure-files]
        (let [original (slurp (boot/tmp-file file))
              revised  (cljfmt/reformat-string original)]
          (util/info (format "Checking %s...\n" path))
          (when-not (= original revised)
            (print-diff context colorize? path original revised)))))
    fileset))
