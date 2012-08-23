(ns clojurewerkz.support.hashing
  (:require [clojurewerkz.support.internal :as i])
  (:import [com.google.common.hash Hashing HashFunction HashCode]))

;;
;; API
;;

(def ^HashFunction sha1-fn   (Hashing/sha1))
(def ^HashFunction md5-fn    (Hashing/md5))
(def ^HashFunction murmur-fn (Hashing/murmur3_128))

(defprotocol Hashable
  (^com.google.common.hash.HashCode sha1-of [input] "Returns a SHA1 hash code of the input")
  (^com.google.common.hash.HashCode md5-of [input]  "Returns an MD5 hash code of the input"))

(extend-protocol Hashable
  String
  (sha1-of [^String s]
    (.hashString sha1-fn s))
  (md5-of [^String s]
    (.hashString md5-fn s))

  Long
  (sha1-of [^Long l]
    (.hashLong sha1-fn l))
  (md5-of [^Long l]
    (.hashLong md5-fn l)))

(extend i/byte-array-type
  Hashable
  {:sha1-of (fn [^bytes bytes]
              (.hashBytes sha1-fn bytes))
   :md5-of (fn [^bytes bytes]
             (.hashBytes md5-fn bytes))})
