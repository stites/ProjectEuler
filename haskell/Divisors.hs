module Divisors where
divisors n = [ x | x<-[1..n `div` 2],  n `mod` x == 0]
d = sum . divisors
