(ns rna-transcription)

(defn dna-to-rna ^Character [chr]
    (case chr
      \C  \G
      \G  \C
      \T  \A
      \A \U
      (throw (AssertionError. "wrong input"))))

(defn to-rna [dna]
  (apply str (map dna-to-rna dna)))