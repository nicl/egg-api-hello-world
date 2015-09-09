(ns egg-api-hello-world.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :as json]
            [ring.util.response :refer [response]]
            [compojure.handler :as handler]))

(defn now [] (java.util.Date.))

(def api "https://example.com")
(def gtg "/egg/gtg")
(def healthcheck "/egg/healthcheck")
(def deps "/egg/dependencies")

;; example responses

(def hw-response {:uri (str api "/") :data "Hello world!"})
(def healthcheck-response {:uri (str api gtg) :data {:status "OK" :lastRun (now)}})
(def gtg-response {:uri (str api gtg)
                   :status "OK"
                   :lastRun (now)
                   :data {:dependencies [{:uri "example-dep.com"
                                          :status "OK"
                                          :lastRun (now)}]}})

(def not-found {:errorKey "404"
                :errorMessage "Resource not found"})

(defroutes app-routes
  (GET "/" [] (response hw-response))
  (GET gtg [] (response gtg-response))
  (GET healthcheck [] (response healthcheck-response))
  (GET deps [] (response deps-response))
  (route/not-found (response not-found)))

(def app
  (-> (handler/site app-routes)
      (json/wrap-json-response)))
