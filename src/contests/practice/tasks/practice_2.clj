(ns contests.practice.tasks.practice-2
  "https://atcoder.jp/contests/practice/tasks/practice_2"
  (:import (java.util Comparator))
  (:require [clojure.string :as str]))

(set! *warn-on-reflection* true)

(defn- num-comp
  "Natural 3-way comparator for numbers"
  [a b]
  (- a b))

(defn- coll->pair-map
  "(coll->pair-map [1 2 3 4 5])
  => {2 1, 4 3, 5 nil}"
  ([^Comparator compare coll]
   (into {}
         (map (fn [[a b]]
                (if (or (nil? a) (and (not (nil? b)) (neg? (compare a b))))
                  [b a]
                  [a b])))
         (partition 2 2 [nil] coll)))
  ([coll]
   (coll->pair-map num-comp coll)))

(defn- binary-search
  ([a ^Comparator compare xs]
   (let [v (vec (reverse xs))]
     (loop [l 0
            r (- (count xs) 1)]
       (let [m (quot (+ l r) 2)]
         (cond
           (< r l) (- (count xs) m 1)
           (pos? (compare (v m) a)) (recur (inc m) r)
           :else (recur l (dec m)))))))
  ([a xs]
   (binary-search a num-comp xs)))

(declare merge-insertion-sort)

(defn- sort-from-pair-map
  [^Comparator compare m]
  (let [sorted-higher (merge-insertion-sort compare (keys m))
        init-res (cons (get m (first sorted-higher)) sorted-higher)]
    (loop [res init-res
           indices '(0)]
      (let [elem (get m (init-res (first indices)))
            insert-at (binary-search elem compare res)
            new-res (reverse (apply conj
                                    (take insert-at res)
                                    elem
                                    (drop insert-at res)))]
        (recur new-res (rest indices))))))


(defn c1<c2? ^Integer
  [^Character c1 ^Character c2]
  (println (str/join " " ["?" c1 c2]))
  (flush)
  (if (= (read-line) "<") -1 1))

(defn merge-insertion-sort
  "Uses a 3-way comparator"
  [^Comparator compare coll]
  (case (count coll)
    0 coll
    1 coll
    2 (if (pos? (compare (first coll) (second coll)))
        (reverse coll)
        coll)
    (sort-from-pair-map compare (coll->pair-map coll))))

(defn solve
  [^Integer n]
  (sort-by
    identity
    c1<c2?
    (map char (take n (drop 65 (range))))))

;(def input
;  (Integer/parseInt
;    ((string/split (read-line) #" ") 0)))

(defn output
  [ls]
  (println (apply (partial str "! ") ls))
  (flush))

;(output (solve input))
;(System/exit 0)



