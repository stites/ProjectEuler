twentyToWords num =
  case num of
    0 -> ""
    1 -> "one"
    2 -> "two"
    3 -> "three"
    4 -> "four"
    5 -> "five"
    6 -> "six"
    7 -> "seven"
    8 -> "eight"
    9 -> "nine"
    10 -> "ten"
    11 -> "eleven"
    12 -> "twelve"
    13 -> "thirteen"
    14 -> "fourteen"
    15 -> "fifteen"
    16 -> "sixteen"
    17 -> "seventeen"
    18 -> "eighteen"
    19 -> "nineteen"

tensToWords num =
  case num of
    2 -> "twenty"
    3 -> "thirty"
    4 -> "forty"
    5 -> "fifty"
    6 -> "sixty"
    7 -> "seventy"
    8 -> "eighty"
    9 -> "ninety"

getHeadToInt x = read (head(show x):"") :: Int
getTailToInt x = read (tail(show x)) :: Int
numToWords num | num == 0   = ""
               | num < 20   = twentyToWords num
               | num < 100  = tensToWords(getHeadToInt(num)) ++ numToWords(getTailToInt(num))
               | num == 100 = "onehundred"
               | num < 1000 = twentyToWords(getHeadToInt(num)) ++ "hundredand" ++ numToWords(getTailToInt(num))
               | True       = twentyToWords(getHeadToInt(num)) ++ "thousand" ++ numToWords(getTailToInt(num))

solution = length . numToWords
