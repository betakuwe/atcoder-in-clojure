(ns contests.abs.tasks.abc087-b
  "https://atcoder.jp/contests/abs/tasks/abc087_b"
  (:require [clojure.set :as set]))

(set! *warn-on-reflection* true)

(defn ways [abc x]
  (-> (reduce (fn [m k]
                (let [abcs (m k)
                      updater (fn [index curr-abcs]
                                (->> (map #(update % index inc) abcs)
                                     (filter #(every? identity (map <= % abc)))
                                     set
                                     (set/union curr-abcs)))]
                  (-> (dissoc m k)
                      (update (+ k 500) (partial updater 0))
                      (update (+ k 100) (partial updater 1))
                      (update (+ k 50) (partial updater 2)))))
              {0 #{[0 0 0]}}
              (range 0 x 50))
      (get x)
      count))

(prn (ways [(read) (read) (read)] (read)))

; naive implementation using memoize but fails
; I think because of using too much memory?
;(def ways-memo
;  (memoize
;    (fn [a b c x]
;      (prn a b c x)
;      (cond
;        (some neg? [a b c x]) 0
;        (= x 0) 1
;        :else (transduce
;                (map-indexed #(apply ways-memo (update [a b c (- x %2)] %1 dec)))
;                +
;                [500 100 50])))))

;(prn (ways (read) (read) (read) (read)))
