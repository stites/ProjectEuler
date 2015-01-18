module Euler where
{-# OPTIONS_GHC -O2 #-}
import Data.Array.Unboxed

divisors n = [ x | x<-[1..n `div` 2],  n `mod` x == 0]
d = sum . divisors

-- from 6.2 in:
-- https://www.haskell.org/haskellwiki/Prime_numbers
primesToNA n = 2: [i | i <- [3,5..n], ar ! i]
  where
    ar = f 5 $ accumArray (\ a b -> False) True (3,n)
         [(i,()) | i <- [9,15..n]]
    f p a | q > n = a
          | True  = if null x then a' else f (head x) a'
      where q = p*p
            a' :: UArray Int Bool
            a'= a // [(i,False) | i <- [q, q+2*p..n]]
            x = [i | i <- [p+2,p+4..n], a' ! i]
isprime x | x == 2          = 1
          | x < 2 || even x = 0
          | otherwise       = go 3
 where
        r = floor $ sqrt $ fromIntegral x
        go i | i > r          = 1
             | x == i*div x i = 0        -- really, | rem x i == 0 = 0
             | otherwise      = go (i+2)
