(ns contests.abs.tasks.abc088-b
  "https://atcoder.jp/contests/abs/tasks/abc088_b")

(set! *warn-on-reflection* true)

(defn card-game [as]                                        ; (2 7 4)
  (->> (sort as)                                            ; (2 4 7)
       reverse                                              ; (7 4 2)
       (partition 2 2 [0])                                  ; ((7 4) (2 0))
       (apply map list)                                     ; ((7 2) (4 0))
       (map (partial apply +))                              ; (9 4)
       (apply -)                                            ; 5
       abs))                                                ; 5

(-> (read)
    (repeatedly read)
    card-game
    prn)
