(ns clojurewerkz.support.url-test
  (:require [clojurewerkz.support.url :as u])
  (:use clojure.test))


(deftest test-url-encode
  (testing "with http"
    (let [host "http://localhost:9200"
          path "/some index/some mapping"]
      (is (= "http://localhost:9200/some%20index/some%20mapping"
             (u/url-encode host path)))))
  (testing "with https"
    (let [host "https://localhost:9200"
          path "/some index/some mapping"]
      (is (= "https://localhost:9200/some%20index/some%20mapping"
             (u/url-encode host path))))))
