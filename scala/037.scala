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

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import scala.collection.parallel.mutable
import scala.compat.Platform
import java.lang.Integer.parseInt

object GenuineEratosthenesSieve extends App {
  def sieveOfEratosthenes(limit: Int) = {
    val (primes: mutable.ParSet[Int], sqrtLimit) = (mutable.ParSet.empty ++ (2 to limit), math.sqrt(limit).toInt)
    @tailrec
    def prim(candidate: Int): Unit = {
      if (candidate <= sqrtLimit) {
        if (primes contains candidate) primes --= candidate * candidate to limit by candidate
        prim(candidate + 1)
      }
    }
    prim(2)
    primes
  }
  // BitSet toList is shuffled when using the ParSet version. So it has to be sorted before using it as a sequence.

  assert(sieveOfEratosthenes(15099480).size == 976729)
  println(s"Successfully completed without errors. [total ${Platform.currentTime - executionStart} ms]")
}

val primes = GenuineEratosthenesSieve.sieveOfEratosthenes(100000)
val elevenPrimes = new ListBuffer[Int]()
var index = 0

def recursivePrime(n:Int): Boolean = {
  val nStr = n.toString
  if (nStr.length == 1) {
    primes(n)
  } else {
    if (primes(n)) {
      recursivePrime( parseInt(nStr.tail) )
    } else {
      false
    }
  }
}

while (index < primes.size || elevenPrimes.size < 10) {
  if (recursivePrime(index) && recursivePrime(parseInt(index.toString.reverse)) ){
    elevenPrimes += index
  }
  index += 1
}

