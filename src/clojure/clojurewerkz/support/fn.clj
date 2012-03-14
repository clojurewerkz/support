(ns clojurewerkz.support.fn)

(defn fpartial
  "Like clojure.core/partial but prepopulates last N arguments (first is passed in later)"
  [f & args]
  (fn [arg & more] (apply f arg (concat args more))))
