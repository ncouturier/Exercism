(ns word-count)

(defn normalize [s]
  (->> (clojure.string/lower-case s)
       (re-seq #"[\w]+")))

(defn word-count [s]
  (->> (normalize s)
       (frequencies)))