(ns say)

(def data (hash-map :powerten (hash-map  1 "ten" 2 "hundred" 3 "thousand" 4 "million" 5 "billion")
                    :numbers ["one","two","three","four", "five", "six","seven","eight","nine"]
                    :teens ["ten","eleven","twelve", "thirteen", "fourteen", "fifteen","sixteen","seventeen", "eighteen","nineteen"]
                    :tenish ["ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"]))

(defn number [num]
    (->> (cond (< num 0) (throw (IllegalArgumentException. "Wrong input."))
               (> num 999999999999) (throw (IllegalArgumentException. "Wrong input."))
               (= num 0) "zero"
               (< num 10 ) ((data :numbers) (- num 1))
               (< num 20 ) ((data :teens) (- num 10)))))


(defn low-hundred [num]
    (let [n (rem num 10) t (quot  num 10)]
        (str ((data :tenish) (- t 1)) ((data :numbers ) (- n 1)))))








