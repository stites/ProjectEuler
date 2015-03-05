/*
 * Truncatable primes
 * Problem 37
 *
 * The number 3797 has an interesting property. Being prime itself, it is
 * possible to continuously remove digits from left to right, and remain
 * prime at each stage: 3797, 797, 97, and 7. Similarly we can work from
 * right to left: 3797, 379, 37, and 3.
 *
 * Find the sum of the only eleven primes that are both truncatable from
 * left to right and right to left.
 *
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */

import scala.collection.mutable.ListBuffer
import java.lang.Integer.parseInt

val primes = sieveOfEratosthenes(1000000)
val elevenPrimes = new ListBuffer[Int]()
var index = 9

def recursivePrime(n:Int, left:Boolean): Boolean = {
  val nStr = n.toString
  if (nStr.length == 1) {
    primes(n)
  } else if (primes(n)) {
    if (left) {
      recursivePrime( parseInt(nStr.tail), left )
    } else {
      recursivePrime( parseInt(nStr.init), left )
    }
  } else {
    false
  }
}

while (index < primes.size || elevenPrimes.size < 11) {
  if (recursivePrime(index, true) && recursivePrime(index, false) ){
    elevenPrimes += index
  }
  if (index % 1000 == 0) {
    println("index at", index)
  }
  index += 1
}

val solution = elevenPrimes.reduceLeft((acc, n) => acc + n)

