(defproject clojurewerkz/support "1.6.0-SNAPSHOT"
  :description "A support library ClojureWerkz projects (Langohr, Monger, Welle, Neocons, Elastisch, Quartzite, etc) can rely on"
  :min-lein-version "2.5.1"
  :url "http://github.com/clojurewerkz/support"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.google.guava/guava "21.0"]]
  :profiles {:dev {:resource-paths ["test/resources"]
                   :dependencies   [[clj-time              "0.8.0"]
                                    [cheshire              "5.3.1"]]}
             :1.8    {:dependencies [[org.clojure/clojure "1.8.0"]]}
             :master {:dependencies [[org.clojure/clojure "1.10.0"]]}
             :cdj01x {:dependencies [[org.clojure/data.json "0.1.2"]]}
             :cdj02x {:dependencies [[org.clojure/data.json "0.2.4"]]
                      :test-paths   ["cdjtest"]}
             :cdj2x  {:dependencies [[org.clojure/data.json "2.5.1"]]
                      :test-paths   ["cdjtest"]}}
  :repositories {"sonatype" {:url "http://oss.sonatype.org/content/repositories/releases"
                             :snapshots false
                             :releases {:checksum :fail :update :always}}
                 "sonatype-snapshots" {:url "http://oss.sonatype.org/content/repositories/snapshots"
                             :snapshots true
                             :releases {:checksum :fail :update :always}}}
  :aliases {"all" ["with-profile" "dev:dev,1.8:dev,master:dev,cdj01x:dev,cdj02x:dev,cdj2x"]}
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]
  :global-vars {*warn-on-reflection* true})
