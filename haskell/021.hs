-- Amicable numbers
-- Problem 21
--
-- Let d(n) be defined as the sum of proper divisors of n (numbers less than n
-- which divide evenly into n).
--
-- If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair
-- and each of a and b are called amicable numbers.
--
-- For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
-- 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
-- 71 and 142; so d(284) = 220.
--
-- Evaluate the sum of all the amicable numbers under 10000.
import Divisors

a   = [ 0..10000 ]
da  = [ d x | x <- a  ]
amicable x y = y < 10000 && (not $ x == y) && (y == (da!!x)) && (x == (da!!y))
pairSums = [ x + y | x <- a, y <- da, amicable x y ]
solution = sum pairSums

-- elegant
dda = [ d x | x <- da ]
solution2 = sum [ x+y | x<-a, y<-da, (not (x == y)) && (dda!!x == x)]
