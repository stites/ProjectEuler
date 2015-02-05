-- Circular primes
-- Problem 35
-- The number, 197, is called a circular prime because all rotations of the
-- digits: 197, 971, and 719, are themselves prime.
--
-- There are thirteen such primes below 100:
-- 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
--
-- How many circular primes are there below one million?
import Data.List
import Euler
import qualified Data.Set as Set
cap = 1000000
allPrimes = primesToNA cap
circleN n acc x = let
    r = fromDigits $ rotate $ digits n
  in
    if (r == x)
    then r:acc
    else circleN r (r:acc) x
  where rotate x = (tail x)++[head x]

-- primeCircle n = foldl (\acc n' -> (isprime n' == 1) && acc) True $ circleN n
