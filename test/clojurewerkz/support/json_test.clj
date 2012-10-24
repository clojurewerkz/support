(ns clojurewerkz.support.json-test
  (:use clojure.test)
  (:require [cheshire.custom   :as json]
            [clj-time.core     :as t]
            clojurewerkz.support.json))


(deftest serialization-of-joda-datetime-to-json
  (let [dt (t/date-time 2011 10 13 23 55 0)]
    (is (= "\"2011-10-13T23:55:00.000Z\""
           (json/encode dt)))))

(deftest serialization-of-java-util-date-to-json
  (let [d (.toDate (t/date-time 2011 10 13 23 55 0))]
    (is (= "\"2011-10-13T23:55:00Z\""
           (json/encode d)))))
