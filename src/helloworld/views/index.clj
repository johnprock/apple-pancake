(ns helloworld.views.index
  (:use [hiccup.core]
        ))

(defn view-index []
  (html [:h1 "Welcome"]))
