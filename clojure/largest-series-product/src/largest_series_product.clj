(ns largest-series-product)

(defn test-args [n s] (when (or (not (re-matches #"(\d*)" s))
                                (< n 0)) (throw (AssertionError. "Wrong input."))))

(defn sub-select [from n s]
  (keep-indexed #(when (and  (>= %1 from ) (< %1  (+ from n) )) %2) s))

(defn n-from [n s]
  (let [cnt (count s)]
    (map #(sub-select % n s) (range 0 (+ 1 (- cnt n))))))

(defn largest-product [n s]
  (let [cnt (count s)]
    (test-args n s)
    (->> (map #(Character/digit % 10) s)
         (n-from n)
         (map #(apply  * %))
         (apply max))))