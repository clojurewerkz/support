(ns clojurewerkz.support.http.statuses-test
  (:require [clojurewerkz.support.http.statuses :as s])
  (:use clojure.test))

(deftest test-status-predicates
  (testing "2xx statuses"
    (doseq [s (range 200 299)]
      (is (s/success? s))
      (is (not (s/redirect? s)))
      (is (not (s/client-error? s)))
      (is (not (s/server-error? s)))))
  (testing "3xx statuses"
    (doseq [s (range 300 399)]
      (is (not (s/success? s)))
      (is (s/redirect? s))
      (is (not (s/client-error? s)))
      (is (not (s/server-error? s)))))
  (testing "4xx statuses"
    (doseq [s (range 400 499)]
      (is (not (s/success? s)))
      (is (not (s/redirect? s)))
      (is (s/client-error? s))
      (is (not (s/server-error? s)))))
  (testing "5xx statuses"
    (doseq [s (range 500 599)]
      (is (not (s/success? s)))
      (is (not (s/redirect? s)))
      (is (not (s/client-error? s)))
      (is (s/server-error? s))))
  (testing "409 Conflict"
    (is (s/conflict? 409))
    (is (not (s/conflict? 201)))
    (is (not (s/conflict? 404)))))
