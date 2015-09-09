(defproject egg-api-hello-world "0.1.0-SNAPSHOT"
  :description "An example Hello World Egg"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]
                 [ring/ring-json "0.4.0"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler egg-api-hello-world.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
