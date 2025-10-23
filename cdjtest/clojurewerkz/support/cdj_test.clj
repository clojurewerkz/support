(ns clojurewerkz.support.cdj-test
  (:require [clojure.data.json :as json]
            [clj-time.core     :as t]
            [clojure.test      :refer [deftest is]]
            clojurewerkz.support.json))

(deftest serialization-of-joda-datetime-to-data-json
  (let [dt (t/date-time 2011 10 13 23 55 0)]
    (is (= "\"2011-10-13T23:55:00.000Z\""
          (json/write-str dt)))))

(deftest serialization-of-java-util-date-to-data-json
  (let [d (.toDate (t/date-time 2011 10 13 23 55 0))]
    (is (= "\"2011-10-13T23:55:00.000Z\""
          (json/write-str d)))))
