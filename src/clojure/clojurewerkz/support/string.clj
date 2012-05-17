(ns clojurewerkz.support.string
  (:require [clojure.string :as s]))

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
