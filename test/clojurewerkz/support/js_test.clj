(ns clojurewerkz.support.js-test
  (:require [clojurewerkz.support.js :as js])
  (:use clojure.test))

(deftest load-js-resource-using-path-on-the-classpath
  (are [c path] (= c (count (js/load-resource path)))
       62 "resources/js/mapfun1.js"
       62 "resources/js/mapfun1"))
