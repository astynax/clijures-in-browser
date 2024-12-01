(ns core)

(defonce counter (atom 0))

(def widget (.querySelector js/document "#container"))

(defn render!
  ([] (render! nil nil nil @counter))
  ([_ _ _ state]
   (-> widget .-children (.item 1) .-innerText
       (set! (str state)))))

(defn counter-inc [] (swap! counter inc))
(defn counter-dec [] (swap! counter dec))

(set! (.-innerHTML widget)
      (str "<button onclick=\"core.counter_dec()\">-</button>"
           "<span>0</span>"
           "<button onclick=\"core.counter_inc()\">+</button>"))

(add-watch counter nil #'render!)
