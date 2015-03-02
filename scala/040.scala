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
var window = "1"
var nextMod = 1
var res = 1
var addedLen = 0
var x = 1

def solve40 (window:String, addedLen:Int, x:Int, nextMod:Int, res:Int, cap:Int): Int = {
  if (nextMod == cap) {
    println("solution", nextMod)
    return res
  } else {
    val cacheSize = 1000

    if (window.length % cacheSize == 0) {
      println("cache", addedLen+window.length)
      solve40(window.substring(0,window.length), addedLen+window.length, x+1, nextMod, res*x, cap)
    } else if ((window.length+addedLen) >= nextMod) {
      val idx = window.length + addedLen - nextMod
      val x = window.charAt(idx).toString.toInt
      println("solution", nextMod, res)
      solve40(window.substring(idx,window.length), addedLen+idx, x+1, nextMod*10, res*x, cap)
    } else {
      solve40(window+x.toString, addedLen, x+1, nextMod, res, cap)
    }
  }
}
var solution = solve40(window, addedLen, x, nextMod, res, cap)

