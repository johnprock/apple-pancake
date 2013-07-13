;Patrick Rock
;7/12/2013

(ns helloworld.views.layout
  (:use [hiccup.core]
        [hiccup.page]))

(defn view-head []
  [:head
    [:meta {:name "author" :content "Patrick Rock"}]
    [:meta {:name "description" :content "My personal website"}]
    [:meta {:charset "utf-8"}]
    (include-css "main.css")])

(defn view-layout [body]
  [:body
    [:h1 {:id "name"}  "Patrick Rock"]
    [:div.container body]])
