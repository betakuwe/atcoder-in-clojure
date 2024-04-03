(ns contests.abs.tasks.abc081-a
  "https://atcoder.jp/contests/abs/tasks/abc081_a")

(set! *warn-on-reflection* true)

(->> (read-line)
     (filter #(= % \1))
     count
     println)
