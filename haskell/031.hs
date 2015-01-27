-- Coin sums
-- Problem 31
-- In England the currency is made up of pound, £, and pence, p, and there are
-- eight coins in general circulation:
--
-- 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
-- It is possible to make £2 in the following way:
--
-- 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
-- How many different ways can £2 be made using any number of coins?

tgt = 200
opts = [1, 2, 5, 10, 20, 50, 100, 200]

coinSum 0 _  = [[]]
coinSum n [] =  []
coinSum n coins@(c:rest)
  | c <= n = map (c:) (coinSum (n-c) coins) ++ coinSum n rest
  | otherwise = coinSum n rest

solution = length $ coinSum tgt opts
