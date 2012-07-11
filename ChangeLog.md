## Changes between ClojureWerkz Support 0.6.0 and 0.7.0

### clojurewerkz.support.string/interpolate-vals

`clojurewerkz.support.string/interpolate-vals` is a new function that replaces value placeholders (?)
in the string with their respective positional values:

``` clojure
(clojurewerkz.support.string/interpolate-vals "X = ?" ["42"]) ;= "X = 42"
```



## Changes between ClojureWerkz Support 0.5.0 and 0.6.0

### clojurewerkz.support.string/maybe-append no longer lowercases strings

`clojurewerkz.support.string/maybe-append` no longer lowercases strings, same for `maybe-prepend`



## Changes between ClojureWerkz Support 0.4.0 and 0.5.0

### New clojurewerkz.support.string functions

Several new functions were extracted from [Crawlista](https://github.com/michaelklishin/crawlista):

`clojurewerkz.support.string/maybe-prepend`, `clojurewerkz.support.string/maybe-append`, `clojurewerkz.support.string/maybe-chopl`,
`clojurewerkz.support.string/maybe-chopr`, `clojurewerkz.support.string/hex-to-int`.



## Changes between ClojureWerkz Support 0.3.0 and 0.4.0

### clojurewerkz.support.re/re-gsub

`clojurewerkz.support.re/re-gsub` works like [Ruby's String#gsub](http://www.ruby-doc.org/core-1.9.3/String.html):

``` clojure
(re/re-gsub #"world" "Clojure" "Hello, world") ;= "Hello, Clojure"
(re/re-gsub #"_id$" "" "id_field_id") ;= "id_field"
```

This function was previous in `clojure.contrib.str-utils` in the old monolithic contrib.



### clojurewerkz.support.string/underscore

`clojurewerkz.support.string/underscore` turns `CamelCase` into `snake_case`:

```
Clojure         => clojure
SpecialGuest    => special_guest
SimpleXMLParser => simple_xml_parser
Area51Story     => area51_story
```



### clojurewerkz.support.string/camelize

`clojurewerkz.support.string/camelize` turns `snake_case` into `CamelCase`:

```
clojure       => Clojure
special_guest => SpecialGuest
```


### clojurewerkz.support.math

`clojurewerkz.support.math` is a new namespace with useful mathematical functions core Clojure
and JDK do not provide.


## Changes between ClojureWerkz Support 0.2.0 and 0.3.0

### clojurewerkz.support.js extracted from Monger

clojurewerkz.support.js namespace has been extracted from [Monger, a Clojure MongoDB library](http://clojuremongodb.info). It is a convenience
function for loading JavaScript resources from JVM class path:

``` clojure
(ns my.app
  (:require [clojurewerkz.support.js :as js]))

;; loads mapreduce/mapper1.js from the class path
(js/load-resource "mapreduce/mapper")

;; the same but with file extension
(js/load-resource "mapreduce/mapper1.js")
```


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
