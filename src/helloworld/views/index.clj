;Patrick Rock
;7/12/2013

(ns helloworld.views.index
  (:use [hiccup.core])
  (:require [helloworld.views.layout :as layout]))

(defn view-index []
  (html (layout/view-head) (layout/view-layout "It's alive!")))
