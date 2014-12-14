/*
 * Factorial digit sum
 * Problem 20
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 */
import java.math.BigInteger;

public class _020 {

  public static BigInteger getFactorial (BigInteger root, BigInteger partialFact) {
    if (root.compareTo(BigInteger.ONE) == 1) {
      return getFactorial(root.subtract(BigInteger.ONE), partialFact.multiply(root));
    } else {
      return partialFact;
    }
  }

  public static int sumDigits (BigInteger num) {
    String digitArray = num.toString();
    int sum = 0;
    for (int i = 0; i < digitArray.length(); i++) {
      char ch = digitArray.charAt(i);
      sum += Character.getNumericValue(ch);
    }
    return sum;
  }
  public static void main (String[] args) {
    BigInteger x = new BigInteger(args[0]);
    BigInteger fact = getFactorial(x, BigInteger.ONE);
    System.out.println(fact);
    int sum = sumDigits(fact);
    System.out.println(sum);
  }
}
