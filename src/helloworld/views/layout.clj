;Patrick Rock
;7/12/2013

(ns helloworld.views.layout
  (:use [hiccup.core]
        [hiccup.page]))

(defn view-head []
  [:head
    [:meta {:name "author" :content "Patrick Rock"}]
    [:meta {:name "description" :content "Patrick Rock: Softare Engineer. This site was built with Clojure."}]
    [:meta {:charset "utf-8"}]
    (include-css "main.css")])

(defn view-sidebar []
  [:div {:id "sidebar"}
    [:nav 
      [:h3 {:id "name"} "Patrick Rock"]
      [:ul
        [:li [:a {:href "./"} "Home"]]
        [:li [:a {:href "./about"} "About"]]
        [:li [:a {:href "./writings"} "Writings"]]
        [:li [:a {:href "https://github.com/johnprock"} "Github"]]
        [:li [:a {:href "./contact"} "Contact"]]]]])

(defn view-layout [body]
  [:body
    [:div {:id "wrap"}
      (view-sidebar)
      [:div {:id "main"} body]]])


