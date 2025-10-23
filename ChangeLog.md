## Changes between ClojureWerkz Support 1.5.0 and 1.6.0 (unreleased)

## clojure.data.json

Fix implementation of `clojure.data.json.JSONWriter/-write`

## Changes between ClojureWerkz Support 1.1.0 and 1.5.0

### Guava 21.0

Support now depends on Guava version `21.0`.

### Clojure 1.9 By Default

Support now depends on `org.clojure/clojure` version `1.9.0`.


## Changes between ClojureWerkz Support 1.0.0 and 1.1.0

### Guava 18.0

Support now depends on Guava version `18.0`.

### Cheshire Update

[Cheshire](https://github.com/dakrone/cheshire/) dependency
has been upgraded to version `5.3.1`.

### clj-time Update

[clj-time](https://github.com/clj-time/clj-time/) dependency
has been upgraded to version `0.8.0`.


## Changes between ClojureWerkz Support 0.20.0 and 1.0.0

### Clojure 1.6 By Default

The project now depends on `org.clojure/clojure` version `1.6.0`. It is
still compatible with Clojure 1.4 and if your `project.clj` depends on
a different version, it will be used, but 1.6 is the default now.

We encourage all users to upgrade to 1.6, it is a drop-in replacement
for the majority of projects out there.


### Guava 17.0

Support now depends on Guava version `17.0`.

### Clojure 1.3 Support Dropped

ClojureWerkz Support no longer supports Clojure 1.3.

### Cheshire Update

[Cheshire](https://github.com/dakrone/cheshire/) dependency has been upgraded to version `5.3.0`.


## Changes between ClojureWerkz Support 0.19.0 and 0.20.0

### ByteSource Implementation Fixed For nil

`clojurewerkz.support.bytes/ByteSource` implementation is fixed for
`nil` values.


## Changes between ClojureWerkz Support 0.18.0 and 0.19.0

### Char and Byte Sources

`clojurewerkz.support.bytes/ByteSource` and
`clojurewerkz.support.chars/CharSource` are two new protocols
extracted from various ClojureWerkz projects.

They provide `clojurewerkz.support.bytes/to-byte-array` and
`clojurewerkz.support.bytes/to-char-array` functions that
produce char arrays (`char[]`) and byte arrays (`byte[]`)
from the input.

Default implementations are provided for strings, char arrays
and byte arrays (respectively).


## Changes between ClojureWerkz Support 0.17.0 and 0.18.0

### Char Array Type

`clojurewerkz.support.internal/char-array-type` is a new var that returns
`char[]` type that can be used to extend protocols.



## Changes between ClojureWerkz Support 0.16.0 and 0.17.0

### Cheshire Update

[Cheshire](https://github.com/dakrone/cheshire/) dependency has been upgraded to version `5.2.0`.

In addition, Support no longer uses deprecated namespaces in Cheshire.


## Changes between ClojureWerkz Support 0.15.0 and 0.16.0

### Cheshire Update

[Cheshire](https://github.com/dakrone/cheshire/) dependency has been upgraded to version `5.1.0`.


## Changes between ClojureWerkz Support 0.14.0 and 0.15.0

### Clojure 1.5 By Default

Support now depends on `org.clojure/clojure` version `1.5.1`. It is
still compatible with Clojure 1.3+ and if your `project.clj` depends on
a different version, it will be used, but 1.5 is the default now.

We encourage all users to upgrade to 1.5, it is a drop-in replacement
for the majority of projects out there.

### Guava 14.0.1

Support now depends on Guava version `14.0.1`.


## Changes between ClojureWerkz Support 0.13.0 and 0.14.0

### Cheshire Update

[Cheshire](https://github.com/dakrone/cheshire/) dependency has been upgraded to version `5.0.2`.


## Changes between ClojureWerkz Support 0.12.0 and 0.13.0

### clojurewerkz.support.io

`clojurewerkz.support.io/create-temp-dir` is a new function that
creates temporary directories. It returns `java.io.File` instances
and currently takes no arguments.


### Guava 14

Support now depends on Guava version `14.0-rc2`.


## Changes between ClojureWerkz Support 0.11.0 and 0.12.0

### (Basic) URL Encoding For HTTP API Consumers is Removed

`clojurewerkz.support.url` is removed. It turned out to not be feature complete
enough for some applications. Use [Urly](http://github.com/michaelklishin/urly)
or similar libraries instead.


## Changes between ClojureWerkz Support 0.10.0 and 0.11.0

### (Basic) URL Encoding For HTTP API Consumers

`clojurewerkz.support.url/url-encode` is a convenience function for HTTP API clients
that works around the fact that [different URI parts are encoded differently](http://www.lunatech-research.com/archives/2009/02/03/what-every-web-developer-must-know-about-url-encoding#Thereservedcharactersaredifferentforeachpart).


## Changes between ClojureWerkz Support 0.9.0 and 0.10.0

`clojurewerkz.support.json` will now assume [Cheshire](https://github.com/dakrone/cheshire) `5.0`.



## Changes between ClojureWerkz Support 0.8.0 and 0.9.0

`clojurewerkz.support.json` now supports

 * Cheshire
 * `clojure.data.json` `0.2.x`
 * `clojure.data.json` `0.1.x`

(whichever is available will be extended to support MongoDB data types
and JodaTime date/time types).


## Changes between ClojureWerkz Support 0.7.0 and 0.8.0

### More Robust clojurewerkz.support.json Compilation

`clojurewerkz.support.json` will no longer fail to compile when `clojure.data.json` is not
available.


## Changes between ClojureWerkz Support 0.6.0 and 0.7.0

### Cheshire Support

`clojurewerkz.support.json` will now use [Cheshire](https://github.com/dakrone/cheshire) if it is available. [clojure.data.json](https://github.com/clojure/data.json)
is no longer a hard dependency (but still supported if available).


### Guava 13

Support now depends on Guava version `13.0`.


### Clojure 1.4 By Default

Support now depends on `org.clojure/clojure` version `1.4.0`. It is still compatible with Clojure 1.3 and if your `project.clj` depends
on 1.3, it will be used, but 1.4 is the default now.

We encourage all users to upgrade to 1.4, it is a drop-in replacement for the majority of projects out there.


### clojurewerkz.support.hashing

`clojurewerkz.support.hashing` is a new namespace with convenient hashing functions based on Guava hashing
utilities:

``` clojure
(require '[clojurewerkz.support.hashing :as h])

(h/sha1-of "clojure") ;= a HashCode instance, use clojure.core/str or .asBytes or .asLong
(h/sha1-of 127273277) ;= a HashCode instance
(h/sha1-of (.getBytes "clojure") ;= a HashCode instance

;; etc
(h/md5-of "hashing")
(h/md5-of 1287272777)
(h/md5-of a-byte-array)
```


### clojurewerkz.support.core/pairs->map, clojurewerkz.support.core/map->pairs

`clojurewerkz.support.core/pairs->map` and `clojurewerkz.support.core/map->pairs` are functions that convert
Clojure maps to vectors of pairs and vice versa:

``` clojure
(require '[clojurewerkz.support.core :as c])

(c/pairs->map [[:a 1] [:b 2] [:c 3]]) ;= {:a 1 :b 2 :c 3}
(c/map->pairs {:a 1 :b 2 :c 3}) ;= [[:a 1] [:b 2] [:c 3]]
```



### clojurewerkz.support.testing/when-not-ci

`clojurewerkz.support.testing/when-not-ci` is a macro that evalutes provided forms if the
`CI` env variable is not set:

``` clojure
(when-not-ci
  (deftest test-something
    ;; do something that only can be tested in the local environment
    ;; but not on travis-ci.org and so on
    (is (= 1 2)))
```


### clojurewerkz.support.string/from-byte-buffer

`clojurewerkz.support.string/from-byte-buffer` is a new convention function that produces strings from
[java.nio.ByteBuffer](http://docs.oracle.com/javase/7/docs/api/java/nio/ByteBuffer.html) instances.


### clojurewerkz.support.string/interpolate-vals

`clojurewerkz.support.string/interpolate-vals` is a new function that replaces value placeholders (?)
in the string with their respective positional values:

``` clojure
(clojurewerkz.support.string/interpolate-vals "X = ?" ["42"]) ;= "X = 42"
```

### clojurewerkz.support.string/interpolate-kv

`clojurewerkz.support.string/interpolate-kv` is a new function that replaces named placeholders (`:name`, `:x`, `:age`, etc) in the string with values of their respective keys in the provided map:

``` clojure
(interpolate-kv "X = :x and Y = :y" {:x "42" :y 53}) ;= "X = 42 and Y = 53"
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
