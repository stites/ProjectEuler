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
var window = ""
var nextMod = 1
var solution = 1

for (x <- 1 to cap) {
  window += x.toString
  if (window.length % 1000 == 0) { println(window.length) }

  if (window.length >= nextMod) {
    solution *= window.charAt(nextMod - 1).toString.toInt
    window = window.substring(nextMod - 1,window.length)
    nextMod *= 10

    println(solution)
  }
}

//var n = 1
//while (n < cap) {
//  n *= nextMod
//  nextMod *= 10
//}

