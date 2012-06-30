(ns clojurewerkz.support.string
  (:require [clojure.string :as s]))

;;
;; Implementation
;;

(def ^{:const true} camel-case-splitter "(?<=[A-Z])(?=[A-Z][a-z])|(?<=[^A-Z])(?=[A-Z])")


;;
;; API
;;

(defn truncate
  ([^String s ^long length]
     (if (> length (count s))
       s
       (.substring s 0 length)))
  ([^String s ^long length ^String omission]
     (let [length-with-room-for-omission (- length (count omission))]
       (str (.substring s 0 length-with-room-for-omission) omission))))


(defn camelize
  "Turns snake_case into CamelCase:

   clojure       => Clojure
   special_guest => SpecialGuest"
  [^String s]
  (s/join (map s/capitalize (s/split s #"_"))))


(defn underscore
  "Turns CamelCase into snake_case:

   GL11Version     => gl11_version
   SimpleXMLParser => simple_xml_parser"
  [^String s]
  (let [s2 (.replaceAll s camel-case-splitter " ")
        xs (s/split s2 #" ")]
    (s/join "_" (map #(.toLowerCase ^String %) xs))))


(defn maybe-prepend
  [^String s ^String prefix]
  (if (.startsWith (.toLowerCase s) (.toLowerCase prefix))
    s
    (str prefix s)))

(defn maybe-append
  [^String s ^String suffix]
  (if (.endsWith (.toLowerCase s) (.toLowerCase suffix))
    s
    (str s suffix)))

(defn maybe-chopl
  [^String s ^String prefix]
  (let [ls (.toLowerCase s)]
    (if (.startsWith ls prefix)
      (.replaceAll ls (str "^" prefix) "")
      s)))

(defn maybe-chopr
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
