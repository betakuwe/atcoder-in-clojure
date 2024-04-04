(ns contests.abs.tasks.arc065-a
  "https://atcoder.jp/contests/abs/tasks/arc065_a")

(set! *warn-on-reflection* true)

(defn daydream [s]
  (letfn [(match-word [s w]
            (if (and (seq s) (every? true? (map = s w)))
              (drop (count w) s)))

          (match-words [s]
            (if (seq s)
             (reduce (fn [s w]
                       (if (seq w)
                         (let [match (match-word s w)]
                           (if (some? match)
                             (reduced match)
                             s))))
                     s
                     (map reverse ["dream" "dreamer" "erase" "eraser" nil]))))]

    (->> (reverse s)
         (iterate match-words)
         (take-while some?)
         last
         (#(if (empty? %) "YES" "NO")))))

;(println (daydream (read-line)))