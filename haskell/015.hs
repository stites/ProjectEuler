-- Lattice paths
-- Problem 15
-- Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
-- there are exactly 6 routes to the bottom right corner.
--
-- <<https://projecteuler.net/project/images/p015.gif>>
--
-- How many such routes are there through a 20×20 grid?

-- use central binomial coefficents: http://www.robertdickau.com/manhattan.html

factorial n = product [1..n]
choose n r = ( factorial n ) / ( factorial r * factorial (n-r) )
calculateCentralBinomialCoefficents sides = choose (sides*2) sides

-- calculateCentralBinomialCoefficents 20
-- 137846528820
