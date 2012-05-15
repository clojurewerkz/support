(ns clojurewerkz.support.math
  (:use [clojurewerkz.support.preconditions :only [not-nil?]]))

(defn round
  "Round down a double to the given precision (number of significant digits)"
  [^double d ^long precision]
  {:pre [(not-nil? d) (not-nil? precision)]}
  (let [factor (Math/pow 10 precision)]
    (/ (Math/floor (* d factor)) factor)))
