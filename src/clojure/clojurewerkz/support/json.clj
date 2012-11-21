;; Copyright (c) 2011-2012 Michael S. Klishin
;;
;; The use and distribution terms for this software are covered by the
;; Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;; which can be found in the file epl-v10.html at the root of this distribution.
;; By using this software in any fashion, you are agreeing to be bound by
;; the terms of this license.
;; You must not remove this notice, or any other, from this software.

(ns clojurewerkz.support.json
  (:import [org.joda.time DateTime DateTimeZone ReadableInstant]
           [org.joda.time.format ISODateTimeFormat]))

;; copied from clojure.reducers
(defmacro ^:private compile-if
  "Evaluate `exp` and if it returns logical true and doesn't error, expand to
  `then`.  Else expand to `else`.

  (compile-if (Class/forName \"java.util.concurrent.ForkJoinTask\")
    (do-cool-stuff-with-fork-join)
    (fall-back-to-executor-services))"
  [exp then else]
  (if (try (eval exp)
           (catch Throwable _ false))
    `(do ~then)
    `(do ~else)))

;;
;; API
;;

(try
  (require 'clojure.data.json)
  (catch Throwable t
    false))


;; all this madness would not be necessary if some people cared about backwards
;; compatiblity of the libraries they maintain. Shame on the clojure.data.json maintainer. MK.
(compile-if (and (find-ns 'clojure.data.json)
                 clojure.data.json/JSONWriter)
            (try
              ;; now try extending clojure.data.json 0.2.x protocol
              (extend-protocol clojure.data.json/JSONWriter
                org.joda.time.DateTime
                (-write [^DateTime object out]
                  (clojure.data.json/write (.print (ISODateTimeFormat/dateTime) ^ReadableInstant object) out))

                java.util.Date
                (-write [^java.util.Date object out]
                  (clojure.data.json/write (DateTime. object (DateTimeZone/UTC)) out)))
              (catch Throwable _
                false))
            (comment "Nothing to do, clojure.data.json is not available"))

(compile-if (and (find-ns 'clojure.data.json)
                 clojure.data.json/Write-JSON)
            ;; try extending clojure.data.json 0.1.x protocol
            (try
              (extend-protocol clojure.data.json/Write-JSON
                org.joda.time.DateTime
                (write-json [^DateTime object out escape-unicode?]
                  (clojure.data.json/write-json (.print (ISODateTimeFormat/dateTime) ^ReadableInstant object) out escape-unicode?))

                java.util.Date
                (write-json [^java.util.Date object out escape-unicode?]
                  (clojure.data.json/write-json (DateTime. object (DateTimeZone/UTC)) out escape-unicode?)))
              (catch Throwable _
                false))
            (comment "Nothing to do, clojure.data.json is not available"))


(try
  (require 'cheshire.generate)
  (catch Throwable t
    false))

(try
  (cheshire.generate/add-encoder DateTime
                               (fn [^DateTime dt ^com.fasterxml.jackson.core.json.WriterBasedJsonGenerator generator]
                                 (.writeString generator (.print (ISODateTimeFormat/dateTime) ^ReadableInstant dt))))
  (catch Throwable t
    false))
