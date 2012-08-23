(ns clojurewerkz.support.core)

;;
;; API
;;

(defn assoc-with
  "Like clojure.core/assoc but new value is calculated using a function of two arguments: old value and new value.
   Similar to clojure.core/merge-with."
  ([f m k v]
     (let [ov (get m k)
           nv (apply f [ov v])]
       (assoc m k nv)))
  ([f m k v & kvs]
     (let [ret (assoc-with f m k v)]
       (if kvs
         (recur f ret (first kvs) (second kvs) (nnext kvs))
         ret))))


(defn transform-matching-keys
  "Applies f to keys of map m that match given regular expression pattern"
  [f m pattern]
  (into {} (for [[k v] m]
             [k (if (re-seq pattern (name k))
                  (f v)
                  v)])))


(defn pairs->map
  "Converts a sequence of pairs (e.g. [:a 10]) into a map"
  [xs]
  (reduce (fn [acc [k v]] (assoc acc k v))
          {} xs))

(defn map->pairs
  "Converts a map into a vector of pairs (e.g. [[:a 10] [:b 20]])"
  [m]
  (vec m))
