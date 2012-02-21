(ns gdd2010-clj.test.core
  (:use [gdd2010-clj.core])
  (:use [clojure.test]))

(deftest test-question-1
  (is (= (question-1) 15)))

(deftest test-question-2
  (is (= (question-2) 36)))

(deftest test-question-3
  (is (= (question-3) 445)))

(deftest test-question-3-v2
  (is (= (question-3) 445)))

(deftest test-pretty
  (is (pretty? 4))
  (is (not (pretty? 9)))
  (is (pretty? 14))
  (is (not (pretty? 19)))
  (is (not (pretty? 149)))
  )

(deftest test-question-4
  (is (= (question-4) 3047))
  )

(deftest test-question-4-v2
  (is (= (question-4-v2) 3047))
  )

(deftest test-lame
  (is (not (lame? 123456)))
  (is (lame? 122345))
  (is (not (lame? 123451)))
  )

(deftest test-cool
  (is (cool? 55))
  (is (not (cool? 12)))
  )

(deftest test-unlucky
  (is (not (unlucky? 123456)))
  (is (unlucky? 623456))
  )

(deftest test-question-5
  (is (= (question-5 '("214966" "220686" "225051" "225123" "513514" "673521" "720202" "720568" "720576")) 2))
  )