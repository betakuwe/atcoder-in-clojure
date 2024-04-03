(ns contests.abs.tasks.abc081-b
  "https://atcoder.jp/contests/abs/tasks/abc081_b")

(set! *warn-on-reflection* true)

(->> (repeatedly (read) read)
     (transduce (map (comp count
                           (partial take-while (partial = \0))
                           reverse
                           #(Integer/toBinaryString %)))
                min
                Integer/MAX_VALUE)
     prn)
