(ns clojurewerkz.support.hashing
  (:require [clojurewerkz.support.internal :as i])
  (:import [com.google.common.hash Hashing HashFunction HashCode Hasher]))

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
    (let [^bytes bytes (.getBytes s "UTF-8")
          ^Hasher hsr  (.newHasher sha1-fn)]
      (-> hsr
          (.putBytes ^bytes bytes)
          .hash)))
  (md5-of [^String s]
    (let [^bytes bytes (.getBytes s "UTF-8")
          ^Hasher hsr  (.newHasher md5-fn)]
      (-> hsr
          (.putBytes ^bytes bytes)
          .hash)))

  Long
  (sha1-of [^Long l]
    (let [^Hasher hsr  (.newHasher sha1-fn)]
      (-> hsr (.putLong l) .hash)))
  (md5-of [^Long l]
    (let [^Hasher hsr  (.newHasher md5-fn)]
      (-> hsr (.putLong l) .hash))))

(extend i/byte-array-type
  Hashable
  {:sha1-of (fn [^bytes bytes]
              (let [^Hasher hsr  (.newHasher sha1-fn)]
                (-> hsr (.putBytes bytes) .hash)))
   :md5-of (fn [^bytes bytes]
             (let [^Hasher hsr  (.newHasher md5-fn)]
               (-> hsr (.putBytes bytes) .hash)))})
