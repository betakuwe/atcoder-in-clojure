(ns contests.practice.tasks.practice-1
  "https://atcoder.jp/contests/practice/tasks/practice_1")

(set! *warn-on-reflection* true)

(defn solve
  [a b c s]
  (str (+ a b c) " " s))

(def input (take 4 (repeatedly read)))

(println (apply solve input))
