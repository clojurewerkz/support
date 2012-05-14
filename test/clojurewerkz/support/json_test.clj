(ns clojurewerkz.support.json-test
  (:use clojure.test
        clojurewerkz.support.json)
  (:require [clojure.data.json :as json]
            [clj-time.core     :as t]))


(deftest serialization-of-joda-datetime-to-json-with-clojure-data-json
  (is (= "\"2011-10-13T23:55:00.000Z\"" (json/json-str (t/date-time 2011 10 13 23 55 0)))))

(deftest serialization-of-java-util-date-to-json-with-clojure-data-json
  (is (= "\"2011-10-13T23:55:00.000Z\"" (json/json-str (.toDate (t/date-time 2011 10 13 23 55 0))))))
