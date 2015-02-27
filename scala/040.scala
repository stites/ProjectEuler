/*
 * Champernowne's constant
 * Problem 40
 *
 * An irrational decimal fraction is created by concatenating the positive
 * integers:
 *
 * 0.12345678910 1 112131415161718192021...
 *
 * It can be seen that the 12th digit of the fractional part is 1.
 *
 * If d_n represents the nth digit of the fractional part, find the value of
 * the following expression.
 *
 * d_1 × d_10 × d_100 × d_1000 × d_10000 × d_100000 × d_1000000
 *
 */

// d_1 000 000
val cap = 1000000
var currentWindow = "1"
var len = 0
var solution = 1
var x = 1
var nextMod = 1
var windowSize = 0
var cached = 0
while (len < cap) {
  currentWindow = x.toString
  len += currentWindow.length
  for (a <- x.toString.length to len) {
    cached = a
    if (a % nextMod == 0) {
      windowSize = a - currentWindow.length
      nextMod *= 10
      solution *= currentWindow.charAt(windowSize).toInt
    }
  }
  x += 1
}

