(ns helloworld.views.index
  (:use [hiccup.core]
        [hiccup.page-helpers]))

(defn view-index []
  (html [:h1 "Welcome"]))
