/*
 * Longest Collatz sequence
 * Problem 14
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting
 * numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
import java.util.HashMap;
import java.math.BigInteger;

public class _014 {

  private static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

  private static BigInteger nextCollatz(BigInteger n){
    BigInteger two = BigInteger.valueOf(2);
    BigInteger three = BigInteger.valueOf(3);
    BigInteger one = BigInteger.ONE;
    BigInteger zero = BigInteger.ZERO;
    return (n.mod(two).compareTo(zero) == 0) ? n.divide(two) : n.multiply(three).add(one);
  }

  private static int collatzLength(BigInteger collatz){
    int length = 1;
    BigInteger cachedCollatz = collatz;
    while (collatz.compareTo(BigInteger.ONE) > 0) {
      //if ( !cache.containsKey(collatz) ) {
        collatz = nextCollatz(collatz);
        length++;
        //System.out.printf("new %d:\t%d\n",length, collatz);
      //} else {
        //length += cache.get(collatz);
        //System.out.printf("old %d:\t%d\n",length, collatz);
        //cache.put(cachedCollatz, length);
       // break;
      //}
    }
    return length;
  }

  public static BigInteger longestCollatz(BigInteger cap){
    int longestLen = 0;
    BigInteger longestCol = cap;
    int len;
    do {
      len = collatzLength(cap);
      if (longestLen <= len) {
        longestLen = len;
        longestCol = cap;
      }
      cap = cap.subtract(BigInteger.ONE);
      System.out.printf(":long: %d\t:llen: %d\t:col: %d\t:len: %d\n",longestCol, longestLen, cap, len);
    } while (cap.compareTo(BigInteger.ONE) > 0);
    return longestCol;
  }

  public static void main (String[] args){
    BigInteger x = new BigInteger(args[0]);
    System.out.println(longestCollatz(x));
  }
}
