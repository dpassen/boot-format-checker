(set-env!
 :source-paths #{"src"}
 :dependencies '[[cljfmt           "0.4.1"  :exclusions [org.clojure/clojure]]
                 [lein-cljfmt      "0.4.1"  :exclusions [org.clojure/clojure]]
                 [adzerk/bootlaces "0.1.13" :scope "test"]])

(require '[adzerk.bootlaces :refer :all])

(def +version+ "0.1.0")

(bootlaces! +version+)

(task-options!
 pom  {:project     'boot-format-checker
       :version     +version+
       :description "Boot task to check and fix formatting errors"
       :url         "https://github.com/dpassen1/boot-format-checker"
       :scm         {:url "https://github.com/dpassen1/boot-format-checker"}
       :license     {"EPL" "http://www.eclipse.org/legal/epl-v10.html"}})
