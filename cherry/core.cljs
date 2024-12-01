(ns core
  (:require
   ["https://cdn.skypack.dev/react" :as react]
   ["https://cdn.skypack.dev/react-dom" :as rdom]))

(defn $
  ([elt]
   ($ elt nil))
  ([elt props & children]
   (let [elt (if (keyword? elt) (name elt) elt)]
     (if (map? props)
       (apply react/createElement elt (clj->js props) children)
       (apply react/createElement elt nil props children)))))

(defn Counter []
  (let [[counter setCounter] (react/useState 0)]
    ($ :div
       ($ :button {:onClick #(setCounter (dec counter))} "-")
       ($ :span counter)
       ($ :button {:onClick #(setCounter (inc counter))} "+"))))

(rdom/render
 ($ Counter)
 (.querySelector js/document "#container"))
