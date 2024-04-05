(ns contests.abs.tasks.arc089-a
  "https://atcoder.jp/contests/abs/tasks/arc089_a")

(set! *warn-on-reflection* true)

(defn traveling
  [txys]
  (-> (reduce
        (fn [[t1 x1 y1] [t2 x2 y2 :as txy2]]
          (let [dist (abs (- (+ x1 y1) x2 y2))
                t-dist (- t2 t1 dist)]
            (if (and (<= 0 t-dist) (even? t-dist))
              txy2
              (reduced nil))))
        (vector 0 0 0)
        txys)
      some?
      (if "Yes" "No")))

(def sc (java.util.Scanner. ^Readable *in*))
(defn next-int [] (.nextInt ^java.util.Scanner sc))

; using next-int doesn't seem to be significantly different from  read in performance
(-> (next-int)
    (repeatedly #(vector (next-int) (next-int) (next-int)))
    doall
    traveling
    print)
(flush)