## Changes between ClojureWerkz Support 0.2.0 and 0.3.0

No changes yet.


## Changes between ClojureWerkz Support 0.1.0 and 0.2.0

### clojure.data.json integration with Joda Time is now in Support

clojure.data.json integration with Joda Time has been extracted from Monger, ClojureWerkz's [MongoDB Clojure client](https://github.com/michaelklishin/monger).
To use it, simply require `clojurewerkz.support.json`.


## Changes between ClojureWerkz Support 0.1.0-beta3 and 0.1.0

### support.core/transform-matching-keys

`support.core/transform-matching-keys` applies f to keys of map m that match given regular expression pattern.



## Changes between ClojureWerkz Support 0.1.0-beta2 and 0.1.0-beta3

### support.core/assoc-with

Extracted `assoc-with` from Validateur. `assoc-with` is a product of crossbreeding
of `clojure.core/assoc` and `clojure.core/merge-with`.



## Changes between ClojureWerkz Support 0.1.0-beta1 and 0.1.0-beta2

### support.rest.statuses

Extracted rest.statuses from Neocons, Elastisch and some non-OSS apps.
