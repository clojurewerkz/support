(ns clojurewerkz.support.io
  (:import com.google.common.io.Files))

(defn ^java.io.File create-temp-dir
  []
  ;; once we drop JDK 6 support, this can be
  ;; done via JDK 7's java.nio.files.Files that
  ;; supports directory prefixes. MK.
  (Files/createTempDir))