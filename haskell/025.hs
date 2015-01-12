-- 1000-digit Fibonacci number
-- Problem 25
-- The Fibonacci sequence is defined by the recurrence relation:
--
-- Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
-- Hence the first 12 terms will be:
--     F1 = 1
--     F2 = 1
--     F3 = 2
--     F4 = 3
--     F5 = 5
--     F6 = 8
--     F7 = 13
--     F8 = 21
--     F9 = 34
--     F10 = 55
--     F11 = 89
--     F12 = 144
-- The 12th term, F12, is the first term to contain three digits.
--
-- What is the first term in the Fibonacci sequence to contain 1000 digits?

fib = fst . fib2

      -- | Return (fib n, fib (n + 1))
fib2 0 = (1, 1)
fib2 1 = (1, 2)
fib2 n
  | even n    = (a*a + b*b, c*c - a*a)
  | otherwise = (c*c - a*a, b*b + c*c)
  where (a,b) = fib2 (n `div` 2 - 1)
        c     = a + b

solution digitCap f =
  let x = fib f in
    if (x `div` (10 ^ (digitCap-1))) > 1
    then f-1
    else solution digitCap (f+1)

-- solution 1000 1000
