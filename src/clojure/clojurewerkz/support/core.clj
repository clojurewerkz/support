(ns clojurewerkz.support.core)

;;
;; API
;;

(defn assoc-with
  ([f m k v]
     (let [ov (get m k)
           nv (apply f [ov v])]
       (assoc m k nv)))
  ([f m k v & kvs]
     (let [ret (assoc-with f m k v)]
       (if kvs
         (recur f ret (first kvs) (second kvs) (nnext kvs))
         ret))))
