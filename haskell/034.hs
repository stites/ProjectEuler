-- Digit factorials
-- Problem 34
-- 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
--
-- Find the sum of all numbers which are equal to the sum of the factorial of
-- their digits.
--
-- Note: as 1! = 1 and 2! = 2 are not sums they are not included.
import Euler

cap = 100000

isCurious n = n == foldl (\ acc d -> acc + product [1..d]) 0 $ digits n

solution = sum [ x | x<-[3..cap], isCurious x]

