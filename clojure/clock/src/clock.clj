(ns clock)
(require '(java-time))

(defn clock->string [clock]
    (let [hours (:hours @clock) minutes (:minutes @clock)]
        (java-time/format "%k:%MZ" (java-time/local-time hours minutes))))



(defn clock [hours minutes]
    (atom {:hours hours
           :minutes minutes}))

(defn add-time [clock time]) ;; <- arglist goes here
  ;; your code goes here

