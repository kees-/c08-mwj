(ns kees.c08.views
  (:require [kees.c08.rf :as rf :refer [<sub >evt]]
            [kees.c08.views.signup :as views.signup]
            [kees.c08.views.fishtank :as views.fishtank]))

(defn routes
  "Return the content of a route."
  ; Could be improved, i.e protocol
  [hash]
  (case hash
    "" [views.fishtank/tank]
    "list" [views.signup/signup-list]
    ;; "horses" [views.horses/main]
    [views.fishtank/tank]))

;; ========== COMPONENTS =======================================================
(defn ph-number
  []
  [:a#ph
   {:href "tel:+13108481990"}
   [:article "+1 310 848 1990"]])

(defn signup-list
  []
  [:a#signup-link
   {:href "#list"}
   "News"])

(defn logo
  []
  [:a#logo-container
   {:href "#"}
   [:article#logo "MWJ"]])

(defn main
  "Body in charge of rendering the content of the route detected by handler."
  []
  (let [route (<sub [::rf/current-route])]
    [:main (routes route)]))

(defn root-panel
  "Main panel always rendered by mount-root."
  []
  [:<>
   [main]
   [logo]
   [ph-number]
   [signup-list]])
