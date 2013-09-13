(ns clojurewerkz.support.bytes
  (:require [clojurewerkz.support.internal :as i]))


(defprotocol ByteSource
  (to-bytes [input] "Converts the input to a byte array"))

(extend-protocol ByteSource
  String
  (to-bytes [^String input]
    (.getBytes input "UTF-8")))

(extend i/byte-array-type
  ByteSource
  {:to-bytes identity})

(extend nil
  ByteSource
  {:to-char-array (constantly nil)})
