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
allPrimes = primesToNA $ fromIntegral cap
circleN p = subroutine p []
  where subroutine n acc = let r = fromDigits $ rotate $ digits n in
         if (r == p)
            then r:acc
            else subroutine r (r:acc)
         where rotate x = (tail x)++[head x]

primeCircle = foldl (\acc n' -> (isprime n' == 1) && acc) True

solution = getCircularPrimes allPrimes Set.empty
  where getCircularPrimes ps s = let
           nextPs   = circleN $ fromIntegral $ head ps
           allPs    = primeCircle nextPs
           addToSet = not (Set.member (head ps) s) && allPs
         in
           if null allPrimes
              then Set.size s
              else if addToSet
                      then getCircularPrimes (tail ps) $ Set.union s (Set.fromList $ map fromIntegral nextPs)
                      else getCircularPrimes (tail ps) s
