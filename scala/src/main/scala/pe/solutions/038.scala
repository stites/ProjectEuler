package pe.solutions

/*
 * Pandigital multiples
 * Problem 38
 *
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 *
 *     192 × 1 = 192
 *     192 × 2 = 384
 *     192 × 3 = 576
 *
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We
 * will call 192384576 the concatenated product of 192 and (1,2,3)
 *
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4,
 * and 5, giving the pandigital, 918273645, which is the concatenated product
 * of 9 and (1,2,3,4,5).
 *
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as
 * the concatenated product of an integer with (1,2, ... , n) where n > 1?
 *
 */

import java.lang.Integer.parseInt

object q038 {

  //val cap = 987654321 / 2
  val cap = 1000000
  val multiples = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)

  def isPandigital(n: Int): Boolean = {
    val nStr = n.toString
    if (nStr.indexOf("0") == -1) {
      nStr.length == 9 && (nStr.length == nStr.distinct.length)
    } else {
      false
    }
  }

  var largest: Int = 192384576
  var largestStart: Int = 192
  var idx = 192

  while (idx < cap) {
    val panDigitalCandidate = multiples.map(_ * idx).filter(_ <= 987654321).scanLeft("")((acc, x) => acc ++ x.toString).find(_.length == 9)
    if (panDigitalCandidate != None) {
      val panCandidate = parseInt(panDigitalCandidate.get)
      if (isPandigital(panCandidate) && panCandidate > largest) {
        largest = panCandidate
        largestStart = idx
      }
    }
    idx += 1
  }

}