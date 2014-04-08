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

public class _014 {

  private HashMap cache = new HashMap();

  private static int nextCollatz(int n){
    return (n % 2 == 0) ? n/2 : 3*n+1;
  }

  private static int collatzLength(int collatz){
    int length = 1;
    while (collatz > 1) {
      // System.out.printf("idx %d:\t%d\n",length, collatz);
      collatz = nextCollatz(collatz);
      length++;
    }
    return length;
  }

  public static void main (String[] args){
    int x = Integer.parseInt(args[0]);
    System.out.println(collatzLength(x));
  }
}
