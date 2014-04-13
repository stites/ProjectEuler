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
    for (int i = 0; i < str.length; i++){
      sum += parseInt(str[i]);
    }
    // return the sum
  }

  public static BigInteger getSecondPower (int cap) {

  }

  public static void main (String[] args){
    int x = parseInt(args);
    BigInteger n = getSecondPower(x);
    int sum = sumDigits(n);
    System.out.println(sum);
  }
}
