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

cap = 1000000

solve36 val =
  let
    subroutine n sum = if (n < 0)
                       then sum
                       else if (isDoublePal n)
                            then subroutine (n-1) (sum+n)
                            else subroutine (n-1) sum
      where isDoublePal n = (isNumPal n) && (isStrPal $ toBinaryStr n)
  in
    subroutine val 0

solution = solve36 $ cap-1
