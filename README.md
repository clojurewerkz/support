# Clojurewerkz Support Library

This is a yet another support/utility library, targeted at use cases in

 * [Langohr](https://github.com/michaelklishin/langohr)
 * [Elastisch](https://github.com/clojurewerkz/elastisch)
 * [Cassaforte](https://github.com/clojurewerkz/cassaforte)
 * [Monger](https://github.com/michaelklishin/monger)
 * [Neocons](https://github.com/michaelklishin/neocons)
 * [Welle](https://github.com/michaelklishin/welle)
 * [Validateur](https://github.com/michaelklishin/validateur)
 * [Meltdown](https://github.com/clojurewerkz/meltdown)
 * [Quartzite](https://github.com/michaelklishin/quartzite)
 * [Pantomime](https://github.com/michaelklishin/pantomime)
 * [Mailer](https://github.com/clojurewerkz/mailer)
 * [Money](https://github.com/clojurewerkz/money)

and other [Clojure libraries](http://clojurewerkz.org) under the Clojurewerkz umbrella.


## Supported Clojure versions

ClojureWerkz Support requires Clojure 1.8+. The most recent release
is highly recommended.



## Maven Artifacts

### The Most Recent Release

With Leiningen:

    [clojurewerkz/support "1.5.0"]

With Maven:

    <dependency>
      <groupId>clojurewerkz</groupId>
      <artifactId>support</artifactId>
      <version>1.5.0</version>
    </dependency>


## Usage

ClojureWerkz Support is a young library and until documentation guides
are written, it may be challenging to use for anyone except the
author. For code examples, see our test suite.

Once the documentation is ready for the public, we will update this
document.


## Continuous Integration

[![Continuous Integration status](https://secure.travis-ci.org/clojurewerkz/support.png)](http://travis-ci.org/clojurewerkz/support)


CI is hosted by [travis-ci.org](http://travis-ci.org)



## Development

Support uses [Leiningen 2](https://github.com/technomancy/leiningen/blob/master/doc/TUTORIAL.md). Make sure you have it installed and then run tests
against all supported Clojure versions using

    lein all test

Then create a branch and make your changes on it. Once you are done with your changes and all tests pass, submit
a pull request on Github.



## License

Copyright © 2012-2019 Michael S. Klishin, Alex Petrov

Distributed under the Eclipse Public License, the same as Clojure.
