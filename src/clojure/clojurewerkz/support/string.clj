(ns clojurewerkz.support.string
  (:require [clojure.string :as s])
  (:import java.nio.ByteBuffer))

;;
;; Implementation
;;

(def ^{:const true} camel-case-splitter "(?<=[A-Z])(?=[A-Z][a-z])|(?<=[^A-Z])(?=[A-Z])")


;;
;; API
;;

(defn ^String truncate
  ([^String s ^long length]
     (if (> length (count s))
       s
       (.substring s 0 length)))
  ([^String s ^long length ^String omission]
     (let [length-with-room-for-omission (- length (count omission))]
       (str (.substring s 0 length-with-room-for-omission) omission))))


(defn ^String camelize
  "Turns snake_case into CamelCase:

   clojure       => Clojure
   special_guest => SpecialGuest"
  [^String s]
  (s/join (map s/capitalize (s/split s #"_"))))


(defn ^String underscore
  "Turns CamelCase into snake_case:

   GL11Version     => gl11_version
   SimpleXMLParser => simple_xml_parser"
  [^String s]
  (let [s2 (.replaceAll s camel-case-splitter " ")
        xs (s/split s2 #" ")]
    (s/join "_" (map #(.toLowerCase ^String %) xs))))


(defn ^String maybe-prepend
  [^String s ^String prefix]
  (if (.startsWith (.toLowerCase s) (.toLowerCase prefix))
    s
    (str prefix s)))

(defn ^String maybe-append
  [^String s ^String suffix]
  (if (.endsWith (.toLowerCase s) (.toLowerCase suffix))
    s
    (str s suffix)))

(defn ^String maybe-chopl
  [^String s ^String prefix]
  (let [ls (.toLowerCase s)]
    (if (.startsWith ls prefix)
      (.replaceAll ls (str "^" prefix) "")
      s)))

(defn ^String maybe-chopr
  [^String s ^String suffix]
  (let [ls (.toLowerCase s)]
    (if (.endsWith ls suffix)
      (.replaceAll ls (str suffix "$") "")
      s)))

(defn hex-to-int
  [^String s]
  (Long/parseLong (if (.startsWith s "0x")
                    (subs s 2)
                    s) 16))

(defn ^java.nio.ByteBuffer to-byte-buffer
  "Wraps provided string into a NIO ByteBuffer"
  ([^String s]
     (ByteBuffer/wrap (.getBytes s "UTF-8")))
  ([^String s ^String encoding]
     (ByteBuffer/wrap (.getBytes s encoding))))

(def ^{:const true}
  interpolation-placeholder-pattern #"\?")

(defn char-counter
  "Returns a function that counts character occurences in a string"
  [^Character ch]
  (fn [^String s]
    (count (filter (fn [c] (= ch c)) (map identity s)))))

(def count-placeholders (char-counter \?))

(defn interpolate-vals
  "Replaces value placeholders (?) in the string with their respective positional values.

   Examples:

   (interpolate-vals \"X = ?\" [\"42\"]) ;= \"X = 42\""
  [^String pattern values]
  {:pre [(= (count-placeholders pattern) (count values))]}
  (let [parts  (s/split pattern interpolation-placeholder-pattern)
        [xs ys](split-at (count values) parts)
        zs     (interleave xs values)]
    (s/join (concat zs ys))))

(defn- interpolate-pair
  [^String s [k v]]
  (.replaceAll s (str k) (str v)))

(defn interpolate-kv
  "Replaces named placeholders (:name, :x, :age, etc) in the string with values of their respective keys in the provided map.

   Examples:

   (interpolate-kv \"X = :x\" {:x \"42\"}) ;= \"X = 42\""
  [^String pattern m]
  (reduce interpolate-pair pattern m))



(defn from-byte-buffer
  "Creates a new string from the contents of the provided NIO byte buffer"
  [^java.nio.ByteBuffer buf]
  (let [ary (byte-array (.remaining buf))]
    (.mark buf)
    (.get buf ary)
    (.reset buf)
    (String. ^bytes ary)))