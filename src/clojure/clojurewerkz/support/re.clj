(ns clojurewerkz.support.re)

;;
;; API
;;

(defn re-partition
  "Splits the string into a lazy sequence of substrings, alternating
  between substrings that match the patthern and the substrings
  between the matches.  The sequence always starts with the substring
  before the first match, or an empty string if the beginning of the
  string matches.

  Originally from clojure.contrib.str-utils

  Example:

  (re-partition #\"[a-z]+\" \"abc123def\")
  ;= (\"\" \"abc\" \"123\" \"def\")"

  [^java.util.regex.Pattern re ^String string]
  (let [m (re-matcher re string)]
    ((fn step [prevend]
       (lazy-seq
         (if (.find m)
           (cons (.subSequence string prevend (.start m))
                 (cons (re-groups m)
                       (step (+ (.start m) (count (.group m))))))
           (when (< prevend (.length string))
             (list (.subSequence string prevend (.length string)))))))
     0)))


(defn re-gsub
  "Replaces all instances of 'pattern' in 'string' with
  'replacement'. Like Ruby's 'String#gsub'.
 
  If (ifn? replacment) is true, the replacement is called with the
  match.

  Originally from clojure.contrib.str-utils"

  [^java.util.regex.Pattern regex replacement ^String string]
  (if (ifn? replacement)
    (let [parts (vec (re-partition regex string))]
      (apply str
             (reduce (fn [parts match-idx]
                       (update-in parts [match-idx] replacement))
                     parts (range 1 (count parts) 2))))
    (.. regex (matcher string) (replaceAll replacement))))
