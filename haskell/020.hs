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
d n = sum [ x | x<-[1..n-1],  ((n `mod` x) == 0)]
pair a b = (not $ a == b) && (d a == b) && (d b == a)
a = [2..10000]
da = [ d x | x <- a ]
amicable x dx = (not $ x == dx) && (dx == (a!!dx)) && (x == (da!!x))
pairSums = [ x + y | x <- a, y <- da, amicable x y ]
solution = sum pairSums
