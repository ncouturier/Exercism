(ns diamond)


(defn char-range [start end]
  (map char (range (int start) (inc (int end)))))

(defn complete [s]
  ( concat (reverse s) (rest  s)))

(defn build-str [cnt idx chr]
  (let [base (vec (take cnt (repeat \space))) motif (update-in base [idx] (fn [_] chr))]
    (->> (complete motif)
         (into [])
         (apply str))))


(defn diamond [^Character c]
  (let [chars (char-range \A c) cnt (count chars)]
    (->> (map-indexed (partial build-str cnt ) chars)
         (into [])
         reverse
         complete)))

