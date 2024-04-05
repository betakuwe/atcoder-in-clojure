(ns template)

(defmacro tt
  "Tests expressions, printing the expressions and their results."
  [& exprs]
  (-> (map #(list 'println `'~% "\n" % "\n") exprs)
      (conj 'do)))

(defn pp
  "Print and return the value. Useful for debugging within threads"
  ([x]
   (println x)
   x)
  ([f x]
   (println (f x))
   x))

(set! *warn-on-reflection* true)

(require '[clojure.string :as str])

(comment
  (str/join nil))
