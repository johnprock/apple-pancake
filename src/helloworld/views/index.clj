;Patrick Rock
;7/12/2013

(ns helloworld.views.index
  (:use [hiccup.core])
  (:require [helloworld.views.layout :as layout]))

(defn view-about []
	(html (layout/view-head) (layout/view-layout (layout/about-form))))

(defn view-writings [postnum]
	(html (layout/view-head) (layout/view-layout (layout/writings-form postnum))))

(defn view-contact []
	(html (layout/view-head) (layout/view-layout (layout/contact-form))))

(defn view-projects []
	(html (layout/view-head) (layout/view-layout (layout/projects-form))))

