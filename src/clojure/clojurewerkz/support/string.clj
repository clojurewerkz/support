(ns clojurewerkz.support.string)

(defn truncate
  ([^String s ^long length]
     (if (> length (count s))
       s
       (.substring s 0 length)))
  ([^String s ^long length ^String omission]
     (let [length-with-room-for-omission (- length (count omission))]
       (str (.substring s 0 length-with-room-for-omission) omission))))
