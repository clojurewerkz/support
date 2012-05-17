(ns clojurewerkz.support.string-test
  (:require [clojurewerkz.support.string :as s])
  (:use clojure.test))

(deftest test-truncate
  (testing "truncation without omission"
    (are [o i l] (is (= o (s/truncate i l)))
         "Hello World!" "Hello World!" 13
         "Hello World!" "Hello World!" 12
         "Hello World"  "Hello World!" 11
         "Hello"        "Hello World!" 5))
  (testing "truncation with omission"
    (are [o i l] (is (= o (s/truncate i l "[...]")))
         "Hello Wo[...]" "Hello World!" 13
         "Hello W[...]"  "Hello World!" 12
         "Hello [...]"   "Hello World!" 11
         "Hello[...]"    "Hello World!" 10
         "He[...]"       "Hello World!" 7)))


(deftest test-camelize
  (are [a b] (is (= (s/camelize a) b))
    "product"       "Product"
    "special_guest" "SpecialGuest"
    "area51_story"  "Area51Story"))