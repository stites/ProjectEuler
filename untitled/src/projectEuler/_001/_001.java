package projectEuler._001;
import java.util.LinkedList;

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

    // getMultiples returns a LinkedList of all multiples
    // of 3 or 5 up until the it's input cap
    private static LinkedList getMultiples (int cap){
        LinkedList<Integer> multiples = new java.util.LinkedList<Integer>();
        for (int i = 3; i <= cap; i++)
        {
            if (i % 3 == 0 | i % 5 == 0)
            {
                multiples.add(i);

            }
        }
        return multiples;
    }

    public static void main (String[] args){
        LinkedList multiplesList = getMultiples(1000);

    }
}
