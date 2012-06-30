# Clojurewerkz Support Library

This is a yet another support/utility library, targeted at use cases in

 * [Monger](https://github.com/michaelklishin/monger)
 * [Langohr](https://github.com/michaelklishin/langohr)
 * [Neocons](https://github.com/michaelklishin/neocons)
 * [Welle](https://github.com/michaelklishin/welle)
 * [Elastisch](https://github.com/clojurewerkz/elastisch)
 * [Quartzite](https://github.com/michaelklishin/quartzite)
 * [Validateur](https://github.com/michaelklishin/validateur)
 * [Urly](https://github.com/michaelklishin/urly)
 * [Pantomime](https://github.com/michaelklishin/pantomime)
 * [Mailer](https://github.com/clojurewerkz/mailer)
 * [Crawlista](https://github.com/michaelklishin/crawlista)
 * [Money](https://github.com/clojurewerkz/money)

and other [Clojure libraries under the Clojurewerkz umbrella](http://clojurewerkz.org).


## Supported Clojure versions

ClojureWerkz Support is built from the ground up for Clojure 1.3 and up.



## Maven Artifacts

### The Most Recent Release

With Leiningen:

    [clojurewerkz/support "0.6.0"]

With Maven:

    <dependency>
      <groupId>clojurewerkz</groupId>
      <artifactId>support</artifactId>
      <version>0.6.0</version>
    </dependency>


## Usage

ClojureWerkz Support is a very young library and until documentation guides are written,
it may be challenging to use for anyone except the author. For code examples, see our test
suite.

Once the library matures, we will update this document.


## Continuous Integration

[![Continuous Integration status](https://secure.travis-ci.org/clojurewerkz/support.png)](http://travis-ci.org/clojurewerkz/support)


CI is hosted by [travis-ci.org](http://travis-ci.org)



## Development

Neocons uses [Leiningen 2](https://github.com/technomancy/leiningen/blob/master/doc/TUTORIAL.md). Make sure you have it installed and then run tests
against all supported Clojure versions using

    lein2 all test

Then create a branch and make your changes on it. Once you are done with your changes and all tests pass, submit
a pull request on Github.



## License

Copyright © 2012 Michael S. Klishin, Alex Petrov

Distributed under the Eclipse Public License, the same as Clojure.
