(ns anagram)

(defn seq->freq [s]
  (->> (clojure.string/lower-case s)
       frequencies))

(defn anagram? [ word frq item] (and (= (seq->freq item) frq)
                                     (not= (clojure.string/lower-case item ) (clojure.string/lower-case word))))

(defn anagrams-for [word prospect-list]
      (let [ref-freq (seq->freq word)]
        (filter (partial anagram? word ref-freq) prospect-list)))
