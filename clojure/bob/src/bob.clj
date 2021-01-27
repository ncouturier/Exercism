(ns bob)
(use '[clojure.string :only (trim ends-with? upper-case blank?)])

(defn question? [s]
  (-> s (trim) (ends-with? "?")))

(defn yelling? [s]
  (and
    (re-find #"[A-Z]" s)
    (=  (upper-case s) s)))

(defn nothing? [s]  (blank? s))

(defn response-for [s]
                   (cond
                     (nothing? s) "Fine. Be that way!"
                     (and (yelling? s) (question? s)) "Calm down, I know what I'm doing!"
                     (question? s) "Sure."
                     (yelling? s)  "Whoa, chill out!"
                     :else "Whatever."))