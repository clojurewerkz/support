(ns clojurewerkz.support.core-test
  (:require [clojure.set :as st])
  (:use clojure.test
        clojurewerkz.support.core))


(deftest test-assoc-with
  (is (= (assoc-with st/union {} :a #{"should not be nil"}) { :a #{"should not be nil"} }))
  (is (= (assoc-with st/union { :a #{1} } :a #{2}) { :a #{1 2} }))
  (is (= (assoc-with st/union { "key" #{1} } "key" #{2}) { "key" #{1 2} }))
  (is (= (assoc-with st/union { 42 #{1} } 42 #{2}) { 42 #{1 2} }))  
  (is (= (assoc-with st/union { #{"key"} #{1} } #{"key"} #{2}) { #{"key"} #{1 2} }))
  (is (= (assoc-with st/union { [:a :b] #{1} } [:a :b] #{2}) { [:a :b] #{1 2} }))
  (is (= (assoc-with st/union { :a #{1} } :b #{2}) { :a #{1}, :b #{2} }))
  (is (= (assoc-with st/union { :a #{1} } :a #{2}, :b #{3}) { :a #{1 2}, :b #{3} })))
