(ns clojurewerkz.support.bytes
  (:require [clojurewerkz.support.internal :as i]))


(defprotocol ByteSource
  (to-byte-array [input] "Converts the input to a byte array"))

(extend-protocol ByteSource
  String
  (to-byte-array [^String input]
    (.getBytes input "UTF-8")))

(extend i/byte-array-type
  ByteSource
  {:to-byte-array identity})

(extend nil
  ByteSource
  {:to-byte-array (constantly nil)})
