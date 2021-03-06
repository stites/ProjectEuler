-- Quadratic primes
-- Problem 27
-- Euler discovered the remarkable quadratic formula:
--
--   n² + n + 41
--
-- It turns out that the formula will produce 40 primes for the consecutive
-- values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41
-- is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly
-- divisible by 41.
--
-- The incredible formula  n² − 79n + 1601 was discovered, which produces 80
-- primes for the consecutive values n = 0 to 79. The product of the
-- coefficients, −79 and 1601, is −126479.
--
-- Considering quadratics of the form:
--
--   n² + an + b, where |a| < 1000 and |b| < 1000
--
-- where |n| is the modulus/absolute value of n
--
--   e.g. |11| = 11 and |−4| = 4
--
-- Find the product of the coefficients, a and b, for the quadratic expression
-- that produces the maximum number of primes for consecutive values of n,
-- starting with n = 0.
import Euler
ps = primesToNA 1000000
isPrime = (flip elem) ps

-- discovery - all bs are primes at n=0
bs = [ p | p <- ps, p < 1000]
-- if a is odd, b is odd & vice versa at n=1
as = [ x | x<-[-999..999], x `mod` 2 == 1 ]

seqLen a b n =
  let x = (n*n)+(a*n)+b in
  if (not $ isPrime(x))
  then (n, a, b)
  else if (n > b)
       then (n, a, b)
       else seqLen a b ( n+1 )

seqs = [ seqLen a b 0 | a <- as, b <- bs ]
solution = let (_, a, b) = maximum seqs in a * b
