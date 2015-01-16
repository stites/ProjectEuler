-- Reciprocal cycles
-- Problem 26
-- A unit fraction contains 1 in the numerator. The decimal representation of
-- the unit fractions with denominators 2 to 10 are given:
--   1/2= 0.5
--   1/3= 0.(3)
--   1/4= 0.25
--   1/5= 0.2
--   1/6= 0.1(6)
--   1/7= 0.(142857)
--   1/8= 0.125
--   1/9= 0.(1)
--   1/10= 0.1
--
-- Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can
-- be seen that 1/7 has a 6-digit recurring cycle.
--
-- Find the value of d < 1000 for which 1/d contains the longest recurring
-- cycle in its decimal fraction part.

-- found this hint: One more thing to note is that the maximum recurring
-- cycle length of 1/d is d-1.

-- http://eli.thegreenplace.net/2009/02/25/project-euler-problem-26
remainders n d seqL rs =
  if seqL >= n
  then rs
  else let r = n `rem` d in
    if r == 0
    then rs
    else remainders (r * 10) d (seqL + 1) (r:rs)