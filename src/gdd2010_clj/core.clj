(ns gdd2010-clj.core)

(defn question-1
  {:doc "What does this program do?

  x = 7
  y = 4
  if y > 2, then
    y = y * 2
  else
    x = x * 2
  print (x + y)

  "}
  []
  (def x 7)
  (def y 4)
  (if (> y 2) (def y (* 2 y)) (def x (* 2 x)))
  (+ x y)
  )

(defn question-2 []
  {:doc "How many times does this program print 'hello'?

  for i = 1 to 5
    if i != 2, then
      for j = 1 to 9
        print 'hello'

  "}
  (count
   (for [i (range 1 6)
         j (range 1 10)
         :when (not= i 2)]
     nil
     )
   )
  )

(defn question-3 []
  {:doc "Which numbers, between 5 and 2675 are even and divisible by 3?" }
  (count
   (for [n (range 5 2676)
         :when (and (= (mod n 3) 0)
                    (even? n))]
     n
     )
   )
  )

(defn question-3-v2 []
  {:doc "Which numbers, between 5 and 2675, are even and divisible by 3?" }
  (count
   (for [n (range 5 2676)
         :when (= (mod n 6) 0)]
     n
     )
   )
  )

(defn pretty? [n]
  {:doc "pretty numbers contain at least one 4 and no 9's"}
  (and
   (.contains (str n) "4")
   (not(.contains (str n) "9"))
   )
  )

(defn question-4 []
  {:doc "How many pretty numbers are between 14063 and 24779"}
  (count (for [n (range 14063 24780)
               :when (pretty? n)]
           n))
  )

(defn question-4-v2 []
  {:doc "How many numbers with at least one 4 and no 9's are between 14063 and
  24779"}
  (count (filter (fn [n]
                   (and (.contains (str n) "4" )
                        (not (.contains (str n) "9" ))))
                 (range 14063 24780)))
  )

(defn lame? [n]
  {:doc "Lame numbers are numbers that have two consecutive identical digits"}
  (some true? (for [i (range (- (count (str n)) 1))]
                (= (nth (str n) i) (nth (str n) (+ 1 i)))
                ))
  )

(defn cool? [n]
  {:doc "On a cool number, the sum of its digits is an even number"}
  (even?
   (reduce +
           (map (fn [s] (Integer/parseInt s))
                (for [c (str n)] (str c)))))
  )

(defn unlucky? [n]
  {:doc "Numbers are unlucky if their first digit is identical to its last"}
  (= (first (str n)) (last (str n)))
  )

(def numbers
  '("214966" "220686" "225051" "225123" "513514" "673521" "720202" "720568" "720576")
  )

(defn question-5 [numbers]
  (count (for [n numbers
               :when (and (cool? n)
                          (not (unlucky? n))
                          (not (lame? n)))]
           n))
  )