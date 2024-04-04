(ns contests.abs.tasks.abc085-c
  "https://atcoder.jp/contests/abs/tasks/abc085_c")

(set! *warn-on-reflection* true)

; this shit was fucking hard to get right with the tricky arithmetic

(defn ev [& args]
  (->> (map * args [10000 5000 1000])
       (apply +)))

(require '[clojure.string :as str]
         '[clojure.math :as math])

; divide then round up to next integer
(defn qquot [num div] (- (math/floor-div num (- div))))

(defn otoshidama [n y]
  (let [yy (quot y 1000)
        min10 (max 0 (qquot (- yy (* 5 n)) 5))
        minn (+ (* 10 min10) (- n min10))
        m (mod (- yy minn) 4)
        n10 (+ min10 m)
        minn2 (+ (* 10 n10) (- n n10))
        q (quot (- yy minn2) 4)
        res [n10 q (- n n10 q)]]
    ;(prn 'yy yy 'min10 min10 'minn minn 'm m 'n10 n10 'minn2 minn2 'q q 'res res)
    (if (every? #(<= 0 % n) res)
      res
      [-1 -1 -1])))

(->> (otoshidama (read) (read))
     (str/join #" ")
     println)

(defn ttest []
  (->> (repeatedly #(let [n (inc (rand-int 2000))
                          y (* 1000 (inc (rand-int 20000)))
                          res (otoshidama n y)
                          s (apply ev res)
                          no-soln (= res [-1 -1 -1])
                          correct (or no-soln (= s y))]
                      (when (and no-soln (<= (* n 1000) y (* n 10000)))
                        (println `(otoshidama ~n ~y) res s (if correct "YAY" "FUCK")))
                      correct))
       (take-while true?)
       (take 100)
       dorun))
