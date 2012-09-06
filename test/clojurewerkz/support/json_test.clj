(ns clojurewerkz.support.json-test
  (:use clojure.test
        clojurewerkz.support.json)
  (:require [clojure.data.json :as json]
            [cheshire.custom   :as json2]
            [clj-time.core     :as t]))


(deftest serialization-of-joda-datetime-to-json
  (let [dt (t/date-time 2011 10 13 23 55 0)]
    (is (= "\"2011-10-13T23:55:00.000Z\""
           (json/json-str dt)
           (json2/encode dt)))))

(deftest serialization-of-java-util-date-to-json
  (let [d (.toDate (t/date-time 2011 10 13 23 55 0))]
    (is (= "\"2011-10-13T23:55:00.000Z\""
           (json/json-str d)))
    (is (= "\"2011-10-13T23:55:00Z\""
           (json2/encode d)))))
