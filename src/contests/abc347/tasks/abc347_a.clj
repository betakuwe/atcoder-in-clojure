(ns contests.abc347.tasks.abc347-a
  "https://atcoder.jp/contests/abc347/tasks/abc347_a")


(defmacro tt
  "Tests expressions, printing the expressions and their results."
  [& exprs]
  (-> (map #(list 'println `'~% "\n" % "\n") exprs)
      (conj 'do)))

(set! *warn-on-reflection* true)

(defn divisible [k as]
  (->> (filter #(zero? (mod % k)) as)
       (map #(/ % k))))

(require '[clojure.string :as str])

(let [n (read)
      k (read)]
  (->> (repeatedly n read)
       doall
       (divisible k)
       (str/join #" ")
       println))

;(tt
;  (divisible 2 [2 5 6 7 10])
;  (divisible 1 [3 4 7])
;  (divisible 10 [50 51 54 60 65]))

;(divisible 2 [2 5 6 7 10])
; (1 3 5)
;
;(divisible 1 [3 4 7])
; (3 4 7)
;
;(divisible 10 [50 51 54 60 65])
; (5 6)