;Patrick Rock
;7/13/2013

(ns helloworld.web
  (:use [hiccup.core]
        [postal.core])
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.middleware.stacktrace :as trace]
            [ring.middleware.session :as session]
            [ring.middleware.session.cookie :as cookie]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.basic-authentication :as basic]
            [cemerick.drawbridge :as drawbridge]
            [environ.core :refer [env]]
            (helloworld.views [index :as index])))

(defn send_mail [email email_name message]
  (send-message {:from (str email)
                 :to ["prock2011@gmail.com"]
                 :cc ""
                 :subject "Website message"
                 :body (str message "\n\n\nFrom: " email_name)
                 :X-Tra "hi"}))

(defn- authenticated? [user pass]
  ;; TODO: heroku config:add REPL_USER=[...] REPL_PASSWORD=[...]
  (= [user pass] [(env :repl-user false) (env :repl-password false)]))

(def ^:private drawbridge
  (-> (drawbridge/ring-handler)
      (session/wrap-session)
      (basic/wrap-basic-authentication authenticated?)))

(defroutes app
  (ANY "/repl" {:as req}
       (drawbridge req))
  (GET "/" [] (index/view-about))
  (GET "/about" [] (index/view-about))
  (GET "/writings" [] (index/view-writings))
  (GET "/contact" [] (index/view-contact))
  (POST "/send" [email email_name message] (send_mail email email_name message) (index/view-send email_name))
  (route/files "/" {:root "src/helloworld/views"})
  (ANY "*" []
       (route/not-found (slurp (io/resource "404.html")))))

(defn wrap-error-page [handler]
  (fn [req]
    (try (handler req)
         (catch Exception e
           {:status 500
            :headers {"Content-Type" "text/html"}
            :body (slurp (io/resource "500.html"))}))))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))
        ;; TODO: heroku config:add SESSION_SECRET=$RANDOM_16_CHARS
        store (cookie/cookie-store {:key (env :session-secret)})]
    (jetty/run-jetty (-> #'app
                         ((if (env :production)
                            wrap-error-page
                            trace/wrap-stacktrace))
                         (site {:session {:store store}}))
                     {:port port :join? false})))



;; For interactive development:
;; (.stop server)
;; (def server (-main))
