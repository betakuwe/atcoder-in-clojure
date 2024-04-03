(ns contests.abs.tasks.abc083-b
  "https://atcoder.jp/contests/abs/tasks/abc083_b")

(defn some-sums [n a b]
  (transduce
    (filter (fn [x]
              (as-> (str x) $
                    (transduce (map #(Character/digit ^char % 10)) + $)
                    (<= a $ b))))
    +
    (range 1 (inc n))))

(prn (some-sums (read) (read) (read)))
