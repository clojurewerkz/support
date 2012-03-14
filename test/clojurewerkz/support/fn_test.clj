(ns clojurewerkz.support.fn-test
  (:require [clojurewerkz.support.fn :as f])
  (:use clojure.test))

(deftest test-fpartial
  (let [pf1 (f/fpartial + 3)
        pf2 (f/fpartial - 3)
        pf3 (f/fpartial str ".")]
    (is (= 8  (pf1 5)))
    (is (= 17 (pf2 20)))
    (is (= "Function." (pf3 "Function")))))
