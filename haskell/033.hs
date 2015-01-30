-- Digit cancelling fractions
-- Problem 33
-- The fraction 49/98 is a curious fraction, as an inexperienced mathematician
-- in attempting to simplify it may incorrectly believe that 49/98 = 4/8,
-- which is correct, is obtained by cancelling the 9s.
--
-- We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
--
-- There are exactly four non-trivial examples of this type of fraction, less
-- than one in value, and containing two digits in the numerator and
-- denominator.
--
-- If the product of these four fractions is given in its lowest common terms,
-- find the value of the denominator.
import Euler
import qualified Data.Set as Set

nonTrivial a b = let
    notMod10 = ((/=) 0 ).( flip mod 10 )
  in
    (&&) (notMod10 a) (notMod10 b)
allTerms = [ (a,b) | a <- [10..99], b<-[10..99], a < b, nonTrivial a b ]

isCurious (a,b) = let
    digitSet = (Set.fromList.digits)
    aSet = digitSet a
    aSize = Set.size aSet
    bSet = digitSet b
    bSize = Set.size bSet
  in
    (Set.size $ Set.union aSet bSet) /= (aSize + bSize)
removeDigit (a,b) = let
    digitSet = (Set.fromList.digits)
    aSet = digitSet a
    bSet = digitSet b
    d = Set.intersection aSet bSet
    getRem s = if (Set.size (diff s) == 0) then Set.elemAt 0 s else Set.elemAt 0 $ diff s
                 where diff s = Set.difference s d
  in
    (getRem aSet, getRem bSet)
checkTuple (a,b) = let
    t = removeDigit (a,b)
  in
     t
--    (a / b) == ((fst t) / (snd t))

curiousFractions = foldl reduceCurious [] allTerms
  where
    reduceCurious acc (a,b) = if (isCurious(a,b))
                              then [(a,b)]++acc
                              else acc
