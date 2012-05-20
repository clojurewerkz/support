(ns clojurewerkz.support.re-test
  (:require [clojurewerkz.support.re :as re])
  (:use clojure.test))


(deftest test-re-gsub
  (are [re replacement s result] (is (= result (re/re-gsub re replacement s)))
       #"world" "Clojure" "Hello, world" "Hello, Clojure"
       #"_id$" "" "id_field_id" "id_field"
       #"abc-(\d+)-def" "abc-$1" "abc-883-def" "abc-883"))
