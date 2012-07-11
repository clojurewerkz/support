(ns clojurewerkz.support.string-test
  (:require [clojurewerkz.support.string :as s])
  (:use clojure.test)
  (:import java.nio.ByteBuffer))

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


(deftest test-underscore
  (are [a b] (is (= (s/underscore a) b))
    "Area51Story"  "area51_story"
    "Product"      "product"       
    "SpecialGuest" "special_guest"
    "PDFLoader"    "pdf_loader"
    "lowercase"    "lowercase"
    "SimpleXMLParser" "simple_xml_parser"))


(deftest test-maybe-prepend
  (is (= "www.apple.com" (s/maybe-prepend "apple.com" "www.")))
  (is (= "www.APPLE.com" (s/maybe-prepend "APPLE.com" "www.")))
  (is (= "www.apple.com" (s/maybe-prepend "www.apple.com" "www."))))

(deftest test-maybe-append
  (is (= "apple.com"  (s/maybe-append "apple.com" ".com")))
  (is (= "APPLE.com"  (s/maybe-append "APPLE.com" ".com")))
  (is (= "google.com" (s/maybe-append "google" ".com"))))

(deftest test-maybe-chopl
  (is (= (s/maybe-chopl "www.google.com" "www.") "google.com"))
  (is (= (s/maybe-chopl "google.com" "goo") "gle.com"))
  (is (= (s/maybe-chopl "Google.COM" "google.") "com"))
  (is (= (s/maybe-chopl "www.www2.megacorp.net" "www.") "www2.megacorp.net")))

(deftest test-maybe-chopr
  (is (= (s/maybe-chopr "http://www.google.com/" "/") "http://www.google.com"))
  (is (= (s/maybe-chopr "google.com/" ".com/") "google"))
  (is (= (s/maybe-chopr "Google.COM/" "/") "google.com")))

(deftest test-hexadecimal-to-int
  (are [s i] (is (= (s/hex-to-int s) i))
       "0xFF00FF" 16711935
       "FF00FF"   16711935
       "0xFF0000" 16711680
       "FF0000"   16711680
       "0x001100" 4352
       "001100"   4352))


(deftest test-to-byte-buffer
  (is (= (ByteBuffer/wrap (.getBytes "a string")) (s/to-byte-buffer "a string")))
  (is (= (ByteBuffer/wrap (.getBytes "строка" "UTF-8")) (s/to-byte-buffer "строка" "UTF-8"))))


;; implementation detail
(deftest test-count-placeholders
  (are [s n] (is (= n (s/count-placeholders s)))
    "?" 1
    "? a ?" 2
    "abc" 0
    "?????" 5))

(deftest test-interpolate-vals
  (are [pattern values result] (is (= result (s/interpolate-vals pattern values)))
    "abc" [] "abc"
    "abc ?" ["def"] "abc def"
    "abc ? xy ?" ["def" "z"] "abc def xy z"
    "abc ? ? xyz" ["123" "456"] "abc 123 456 xyz"
    "abc ?? xyz" ["123" "456"] "abc 123456 xyz"
    "? interpolate" ["My name is"] "My name is interpolate"))
