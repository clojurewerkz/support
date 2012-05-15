(ns clojurewerkz.support.math-test
  (:require [clojurewerkz.support.math :as m])
  (:use clojure.test))


(deftest test-round
  (are [a b c] (is (= c (m/round a b)))
    10.1111 2 10.11
    10.0    2 10.00
    10.0    1 10.0
    10.0    0 10.0
    10.5    0 10.0
    99.1    2 99.10))
