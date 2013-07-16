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
        [:li [:a {:href "https://linkedin.com/pub/patrick-rock/77/32a/54a"} "Linkedin"]]
        [:li [:a {:href "./contact"} "Contact"]]]]])

(defn view-layout [body]
  [:body
    [:div {:id "wrap"}
      (view-sidebar)
      [:div {:id "main"} body]]])

(defn contact-form []
  [:div {:id "contact-form"}
    [:header "Contact Me"]
    [:form
      [:fieldset
        [:div.field [:input {:id "email_name" :type "text" :placeholder "Your Name"}]]
        [:div.field [:input {:id "email" :type "text" :placeholder "Your Email Address"}]]
        [:div.field {:id "message"} [:textarea {:id "message" :rows "4" :cols "50" :placeholder "Your Message"}]]
        [:div.field [:button {:id "send" :type "submit"} "Send Message"]]]]
    [:p "Or email me at patrickrock@tamu.edu"]])

(defn about-form []
  [:div {:id "about-form"}
    [:img.pic {:src "profilepic.jpeg"}]
    [:p "Hello this is Patrick"]])
