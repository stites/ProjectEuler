/*
 * Power digit sum
 * Problem 16
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 */
import java.math.BigInteger;

public class _016 {
  public static int sumDigits (BigInteger n){
    String str = n.toString();
    // for loop to iterate over each number in the array
    int sum = 0;
    for (int i = 0; i < str.length(); i++){
      sum += Character.getNumericValue(str.charAt(i));
    }
    return sum;
  }

  public static BigInteger getSecondPower (BigInteger cap) {
    BigInteger two = BigInteger.valueOf(2);
    BigInteger one = BigInteger.ONE;
    BigInteger zero = BigInteger.ZERO;
    BigInteger result = one;

    while (cap.compareTo(zero) > 0){
      result = result.multiply(two);
      cap = cap.subtract(one);
    }
    return result;
  }

  public static void main (String[] args){
    BigInteger x = new BigInteger(args[0]);
    BigInteger n = getSecondPower(x);
    System.out.println(n);
    int sum = sumDigits(n);
    System.out.println(sum);
  }
}
