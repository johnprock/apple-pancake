;Patrick Rock
;7/12/2013

(ns helloworld.views.index
  (:use [hiccup.core])
  (:require [helloworld.views.layout :as layout]))

(defn view-index []
  (html (layout/view-head) (layout/view-layout "Hello I'm Patrick Rock. I'm interested in Jazz and Math.")))

(defn view-about []
	(html (layout/view-head) (layout/view-layout (layout/about-form))))

(defn view-writings []
	(html (layout/view-head) (layout/view-layout "writings")))

(defn view-contact []
	(html (layout/view-head) (layout/view-layout (layout/contact-form))))

