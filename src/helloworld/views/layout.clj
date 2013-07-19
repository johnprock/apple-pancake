;Patrick Rock
;7/12/2013

(ns helloworld.views.layout
  (:use [hiccup.core]
        [hiccup.page])
  (:import java.io.File)
  (:require [helloworld.views.posts :as posts]))

(defn view-head []
  [:head
    [:meta {:name "author" :content "Patrick Rock"}]
    [:meta {:name "description" :content "Patrick Rock: Softare Engineer. This site was built with Clojure."}]
    [:meta {:charset "utf-8"}]
    [:script {:type "text/javascript" :src "shCore.js"}]
    [:script {:type "text/javascript" :src "shBrushHaskell.js"}]
    [:script {:type "text/javascript" :src "shBrushJava.js"}]
    [:script {:type "text/javascript"} "SyntaxHighlighter.all()"]
    (include-css "main.css")
    (include-css "shCore.css")
    (include-css "shThemeDefault.css")])

(defn view-sidebar []
  [:div {:id "sidebar"}
    [:nav 
      [:h3 {:id "name"} "Patrick Rock"]
      [:ul
        [:li [:a {:href "./about"} "Home"]]
        [:li [:a {:href "./writings?postnum=0"} "Writings"]]
        [:li [:a {:href "https://github.com/johnprock"} "GitHub"]]
        [:li [:a {:href "https://linkedin.com/pub/patrick-rock/77/32a/54a"} "LinkedIn"]]
        [:li [:a {:href "./web_resume.pdf"} "Resumé"]]
        [:li [:a {:href "./contact"} "Contact"]]]]])

(defn view-layout [body]
  [:body
    [:div {:id "wrap"}
      (view-sidebar)
      [:div {:id "main"} body]]])

(defn contact-form []
  [:div {:id "contact-form"}
    [:h2 "Contact Me"]
    [:p "I can be reached at "
      [:em "patrickrock@tamu.edu"]
      " or " 
      [:em "prock2011@gmail.com."]]])

(defn about-form []
  [:div {:id "about-form"}
    [:img.pic {:src "profilepic.jpeg"}]
    [:p "Hi I'm Patrick! I'm a jazz musician and a programmer. I'm currently studying computer science at Texas A&M.
         This summer I'm working as a Software Engineering intern at IBM. 
         Compilers are what get me excited in computer science. I'm a big fan of Lisp and Haskell. I also play saxophone and piano semi-professionally."]])

(defn down_post [postnum] ; Go to the next post
  (if (= 0 postnum) 
      postnum
      (- postnum 1)))

(defn up_post [postnum] ; Go to the previous poset
  (if (= postnum (- (count posts/posts) 1))
      postnum
      (+ postnum 1)))

(defn writings-form [poststring]
  (let [postnum (read-string poststring)]
    [:div {:id "writings-form"}
      [:h3 (:title (nth posts/posts postnum))]
      [:div.posts (:content (nth posts/posts postnum))]
      [:small (:date (nth posts/posts postnum))]
      [:div.bottom
        [:a.prev {:href (str "./writings?postnum=" (down_post postnum)) } "Previous"]
        [:a.next {:href (str "./writings?postnum=" (up_post postnum)) } "Next"]]]))


