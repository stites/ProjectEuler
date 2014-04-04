/**
 * Created with IntelliJ IDEA.
 * User: stites
 * Date: 4/3/14
 * Time: 9:16 PM
 *
 * Problem 1
 * Multiples of 3 and 5
 *
 * url: https://projecteuler.net/problem=1
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class _001 {
    public static void main (String[] args){
        int sum=0;
        for (int n=0;n<1000;n+=3) sum+=n;
        for (int n=0;n<1000;n+=5) if (n%3!=0) sum+=n;
        System.out.println(sum);
    }
}
