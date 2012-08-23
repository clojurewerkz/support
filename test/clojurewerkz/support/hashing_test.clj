(ns clojurewerkz.support.hashing-test
  (:require [clojurewerkz.support.hashing :as h])
  (:use clojure.test))


(deftest test-sha1
  (are [input sha1] (is (= sha1 (str (h/sha1-of input))))
    "clojure"             "8b78b1af05706b0dd8d4154f4e625c53ecdfb96a"
    (.getBytes "clojure") "49c91cf925f70570a72cf406e9b112ce9e32250c"
    "SHA1"                "52bdfa54a164366a4cca7f4e8e9d4cc3289b914b"
    12777272              "62ccbb727382b2b1cdb367efeab44151cd871520"))
