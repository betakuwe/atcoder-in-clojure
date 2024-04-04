(ns contests.abs.tasks.arc065-a
  "https://atcoder.jp/contests/abs/tasks/arc065_a")

(set! *warn-on-reflection* true)

(defn daydream [s]
  (letfn [(match-word [s w]
            (when (every? true? (map = s w))
              (drop (count w) s)))

          (match-words [s]
            (when (seq s)
             (reduce (fn [s w]
                       (when (seq w)
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

(println (daydream (read-line)))