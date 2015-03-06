package solutions

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

object q039 {
  var solution = 0
  var resultSolutions = 0

  for (p <- 2 until 1000 by 2) {
    var numberOfSolutions = 0
    for (a <- 2 to (p / 3)) {
      if (p * (p - 2 * a) % (2 * (p - a)) == 0) {
        numberOfSolutions += 1
      }
    }
    if (numberOfSolutions > resultSolutions) {
      resultSolutions = numberOfSolutions
      solution = p
    }
  }
}
