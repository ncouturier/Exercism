(ns armstrong-numbers)

(defn pow [base exp]
  (reduce * (repeat exp base)))

(defn num->digits [num]
  (mapv #(Character/digit ^Character % 10 )  (str num)))

(defn armstrong? [n]
  (let [digits (num->digits n)
        exp (count digits)]
    (= n (apply + (map #(pow % exp) digits)))))