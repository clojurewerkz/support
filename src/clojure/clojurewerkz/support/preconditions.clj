(ns clojurewerkz.support.preconditions
  (:import com.google.common.base.Preconditions))

;;
;; API
;;

(defmacro not-nil?
  [x]
  `(not (nil? ~x)))

(defn check-not-nil
  ([reference]
     (Preconditions/checkNotNull reference))
  ([reference message]
     (Preconditions/checkNotNull reference message)))
