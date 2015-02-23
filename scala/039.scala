/*
 * Integer right triangles
 * Problem 39
 *
 * If p is the perimeter of a right angle triangle with integral length sides,
 * {a,b,c}, there are exactly three solutions for p = 120.
 *
 * {20,48,52}, {24,45,51}, {30,40,50}
 *
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */
import scala.collection.mutable.ListBuffer

def isRight (a:Int, b:Int, c:Int): Boolean = { a*a + b*b == c*c }

def getSides (perimeter:Int): Int = {
  var sides = ListBuffer<_>();

  for (a <- 1 to perimeter/2){
    for (b <- 1 to a) {
      var c = perimeter-a-b;

      if (isRight(a,b,c)) {
        sides += List(a,b,c)
      }
    }
  }

  return 1
}
val example = getSides(120)
