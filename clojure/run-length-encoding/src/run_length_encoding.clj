(ns run-length-encoding)

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (->> plain-text
       (partition-by identity)
       (mapcat (juxt count first))
       (remove #{1})
       (apply str)))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (->> cipher-text
    (re-seq #"(\d+)?(\D)")
    (mapcat #(let [[_ cnt chr ] %]  (repeat (Long/valueOf (or cnt 1)) chr)))
    (apply str)))