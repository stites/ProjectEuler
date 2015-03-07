package pe.solutions

import common._

/*
 * Pandigital prime
 * Problem 41
 *
 * We shall say that an n-digit number is pandigital if it makes use of all
 * the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital
 * and is also prime.
 *
 * What is the largest n-digit pandigital prime that exists?
 *
 */

object q041 {

  val primes = sieveOfEratosthenes(10000)
  var solution = 2143
  for ( p <- primes ) {
    var pStr = p.toString
    if (pStr.toSet.size == pStr.length) {
      if (p > solution) solution = p
    }
  }

}
