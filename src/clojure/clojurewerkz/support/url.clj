(ns clojurewerkz.support.url
  (:import java.net.URI))


(defn url-encode
  "Convenience function for URI encoding of hostname (with optional scheme)
   and URI path. Designed to be used by HTTP API clients."
  ([^String host-with-scheme ^String path]
     (url-encode host-with-scheme path nil))
  ([^String host-with-scheme ^String path ^String query]
     (let [u      (URI. host-with-scheme)
           auth   (.getAuthority u)
           scheme (.getScheme u)
           combined (URI. scheme
                          (.getAuthority u)
                          path
                          query
                          nil)]
       (.toASCIIString combined))))
