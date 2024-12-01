(ns core)

(def state (atom {:state {:counter 0}}))

(def widget (.querySelector js/document "#container"))

(defn render! []
  (-> widget .-children (.item 1) .-innerText
      (set! (-> @state :state :counter))))

(defn counter-dec []
  (swap! state update-in [:state :counter] dec)
  (render!))

(defn counter-inc []
  (swap! state update-in [:state :counter] inc)
  (render!))

(set! (.-innerHTML widget)
      (str "<button onclick=\"counter_dec()\">-</button>"
           "<span>0</span>"
           "<button onclick=\"counter_inc()\">+</button>"))

(set! (.-get_state js/window) (fn [] @state))
(set! (.-counter_dec js/window) counter-dec)
(set! (.-counter_inc js/window) counter-inc)
