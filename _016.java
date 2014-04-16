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
    for (int i = 0; i < str.length()-1; i++){
      sum += Character.getNumericValue(str.charAt(i));
    }
    return sum;
  }

  public static BigInteger getSecondPower (int cap) {
    BigInteger result = BigInteger.ONE;
    StringBuffer chunk = new StringBuffer("10");
    do {
      for (int i=0; cap > 0; cap--, i=(i+1) % 7){
        if (i == 0){
          Byte b = Byte.decode(chunk.toString());
          int bint = b.intValue();
          result = result.multiply( BigInteger.valueOf(bint));
          chunk = new StringBuffer("1");
        }
        chunk.append("0");
      }
    } while (cap > 7);
    return BigInteger.valueOf(cap);
  }

  public static void main (String[] args){
    int x = Integer.parseInt(args[0]);
    BigInteger n = getSecondPower(x);
    System.out.println(n);
    //int sum = sumDigits(n);
    //System.out.println(sum);
  }
}
