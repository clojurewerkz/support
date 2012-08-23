(defproject clojurewerkz/support "0.7.0-beta1"
  :description "A support library ClojureWerkz projects (Langohr, Monger, Neocons, Elastisch, Quartzite, Money, etc) can rely on"
  :min-lein-version "2.0.0"
  :url "http://github.com/clojurewerkz/support"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [com.google.guava/guava "12.0"]]
  :profiles {:dev {:resource-paths ["test/resources"]
                   :dependencies   [[org.clojure/data.json "0.1.2"]
                                    [clj-time              "0.4.2"]]}
             :1.4 {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :1.5 {:dependencies [[org.clojure/clojure "1.5.0-master-SNAPSHOT"]]}}
  :repositories {"sonatype" {:url "http://oss.sonatype.org/content/repositories/releases"
                             :snapshots false
                             :releases {:checksum :fail :update :always}}
                 "sonatype-snapshots" {:url "http://oss.sonatype.org/content/repositories/snapshots"
                             :snapshots true
                             :releases {:checksum :fail :update :always}}}
  :aliases {"all" ["with-profile" "dev:dev,1.4:dev,1.5"]
            "ci"  ["with-profile" "dev:dev,1.4"]}
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]
  :warn-on-reflection true)
