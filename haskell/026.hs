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

import Euler
import Data.List

rpTill = reverse . primesToNA
ps = rpTill 1000

cycleLen n len = if ((10 ^ len - 1) `mod` n == 0)
                 then len
                 else if (n*n > len)
                         then cycleLen n (len+1)
                         else 0
ps30 = fst (splitAt 20 ps)
solution = maximumBy (\ x y -> compare (cycleLen x 1) (cycleLen y 1) ) ps30
