(ns clojurewerkz.support.chars
  (:require [clojurewerkz.support.internal :as i]))


(defprotocol CharSource
  (to-char-array [input] "Converts an input to char[]"))

(extend-protocol CharSource
  String
  (to-char-array [input]
    (.toCharArray input)))

(extend i/char-array-type
  CharSource
  {:to-char-array identity})

(extend nil
  CharSource
  {:to-char-array (constantly nil)})
