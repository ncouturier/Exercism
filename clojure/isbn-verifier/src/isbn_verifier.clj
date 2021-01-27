(ns isbn-verifier)

(defn is-whole-content-valid? [s] (some? (re-matches #"(?:\d-?){9}[\dX]" s)))
(defn isbn->nums [s] (->> (keep #(cond
                                   (= % \X) 10
                                   (Character/isDigit %) (Character/digit % 10)) s)))
(defn checksum? [s]
  (let [coeff (range 10 0 -1) ] (= 0 (mod (reduce + (map * s coeff)) 11))))

(defn isbn? [isbn]
    (and (is-whole-content-valid? isbn)
         (let [d (isbn->nums isbn)] (checksum? d))))