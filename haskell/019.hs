-- Counting Sundays
-- Problem 19
-- You are given the following information, but you may prefer to do some research for yourself.
--
-- * 1 Jan 1900 was a Monday.
-- * Thirty days has September,
--   April, June and November.
--   All the rest have thirty-one,
--   Saving February alone,
--   Which has twenty-eight, rain or shine.
--   And on leap years, twenty-nine.
-- * A leap year occurs on any year evenly
--   divisible by 4, but not on a century
--   unless it is divisible by 400.
--
-- How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
months_noleap = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
months_leap = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

evenlyDivides x y = ( x `mod` y ) == 0
leapCondition yr = (yr `evenlyDivides` 4) && (not (yr `evenlyDivides` 100) || yr `evenlyDivides` 400)

months yr = if leapCondition yr
            then months_leap
            else months_noleap

nextYear'sFirstSunday year r = (sum (r:(months year))) `mod` 7
-- 1 Jan 1901 was a Tuesday, [0 == Sun, so Tuesday is a 2]
firstSunday year = if (year == 1901)
                   then nextYear'sFirstSunday year 5
                   else nextYear'sFirstSunday year (firstSunday(year-1))
sundaysInAYear year = ((+) 31 $ firstSunday year) `mod` 7
solution = sum [sundaysInAYear x | x <- [1901..2000]]
