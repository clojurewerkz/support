(defproject clojurewerkz/support "0.2.0-SNAPSHOT"
  :description "A support library ClojureWerkz projects (Langohr, Monger, Neocons, Elastisch, Quartzite, Money, etc) can rely on"
  :min-lein-version "2.0.0"  
  :url "http://github.com/clojurewerkz/support"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [com.google.guava/guava "11.0.1"]]
  :profiles { :dev { :resource-paths ["test/resources"] }
             :1.4 { :dependencies [[org.clojure/clojure "1.4.0"]] } }
  :repositories {"clojure-releases" "http://build.clojure.org/releases"
                 "sonatype" {:url "http://oss.sonatype.org/content/repositories/releases"
                             :snapshots false
                             :releases {:checksum :fail :update :always}}}  
  :aliases { "all" ["with-profile" "dev:dev,1.4"] }
  :source-paths ["src/clojure"]  
  :java-source-paths ["src/java"]  
  :warn-on-reflection true)
