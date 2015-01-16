module Divisors where
import System.Environment (getArgs)
import Math.NumberTheory.Primes
divisors n = [ x | x<-[1..n `div` 2],  n `mod` x == 0]
d = sum . divisors

main = do
  args <- getArgs
  let lim = case args of
        (a:_) -> read a
        _     -> 1000000
    print . sum $ takeWhile (<= lim) primes
