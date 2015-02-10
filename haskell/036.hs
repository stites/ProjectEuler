-- Double-base palindromes
-- Problem 36
-- The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
--
-- Find the sum of all numbers, less than one million, which are palindromic in
-- base 10 and base 2.
--
-- (Please note that the palindromic number, in either base, may not include
-- leading zeros.)
import Euler

isPal_microOpt val =
  let
    subroutine n mag = if (n `div` mag == 0)
                   then if (n `div` (mag`div`10) == n`mod`10)
                        then isPal n
                        else False
                   else subroutine n $ mag*10
  in
   subroutine val 10
