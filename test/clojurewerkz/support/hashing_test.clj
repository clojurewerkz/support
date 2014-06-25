(ns clojurewerkz.support.hashing-test
  (:require [clojurewerkz.support.hashing :as h])
  (:use clojure.test))


(deftest test-sha1
  (are [input sha1] (is (= sha1 (.toString (h/sha1-of input))))
    "clojure"             "49c91cf925f70570a72cf406e9b112ce9e32250c"
    (.getBytes "clojure") "49c91cf925f70570a72cf406e9b112ce9e32250c"
    "SHA1"                "e1744a525099d9a53c0460ef9cb7ab0e4c4fc939"
    12777272              "62ccbb727382b2b1cdb367efeab44151cd871520"))
