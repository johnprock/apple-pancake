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
        [:li [:a {:href "./about"} "Home"]]
        [:li [:a {:href "./writings"} "Writings"]]
        [:li [:a {:href "https://github.com/johnprock"} "Github"]]
        [:li [:a {:href "https://linkedin.com/pub/patrick-rock/77/32a/54a"} "Linkedin"]]
        [:li [:a {:href "./web_resume.pdf"} "Resume"]]
        [:li [:a {:href "./contact"} "Contact"]]]]])

(defn view-layout [body]
  [:body
    [:div {:id "wrap"}
      (view-sidebar)
      [:div {:id "main"} body]]])

(defn contact-form []
  [:div {:id "contact-form"}
    [:header "Contact Me"]
    [:form {:name "input" :action "/send" :method "post"}
      [:fieldset
        [:div.field [:input {:name "email_name" :type "text" :placeholder "Your Name"}]]
        [:div.field [:input {:name "email" :type "text" :placeholder "Your Email Address"}]]
        [:div.field [:textarea {:name "message" :rows "4" :cols "50" :placeholder "Your Message"}]]
        [:div.field [:button {:type "submit" :value "submit"} "Send Message"]]]]
    [:p "Or email me at patrickrock@tamu.edu"]])

(defn about-form []
  [:div {:id "about-form"}
    [:img.pic {:src "profilepic.jpeg"}]
    [:p "Hi I'm Patrick! I'm a jazz musician and a programmer. I'm currently studying computer science at Texas A&M.
         This summer I'm working as a Software Engineering intern at IBM."]
    [:p "Compilers are what get me excited in computer science. I'm a big fan of Lisp and Haskell. I also play saxaphone and piano semi-professionally."]])
