package object common {

  import scala.annotation.tailrec
  import scala.collection.parallel.mutable

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

}
