(ns contests.abs.tasks.abc086-a
  "https://atcoder.jp/contests/abs/tasks/abc086_a")

(set! *warn-on-reflection* true)

(def input (repeatedly 2 read))

(println (if (every? odd? input) "Odd" "Even"))