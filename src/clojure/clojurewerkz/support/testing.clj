(ns clojurewerkz.support.testing)


;;
;; API
;;

(defmacro when-not-ci
  "Evaluates given forms when the CI env variable is not set"
  [& forms]
  `(when-not (System/getenv "CI")
     (do ~@forms)))
