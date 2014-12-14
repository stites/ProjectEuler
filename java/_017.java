/*
 * Number letter counts
 * Problem 17
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23
 * letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 */

public class _017 {
  private static LinkedHashMap numbersToWords = LinkedHashMap<Integer, String>();
  private static LinkedHashMap numbersToPlace = LinkedHashMap<Integer, String>();

  private static void initHashMaps(){
    numbersToWords.put(0: 'zero');
    numbersToWords.put(1: 'one');
    numbersToWords.put(2: 'two');
    numbersToWords.put(3: 'three');
    numbersToWords.put(4: 'four');
    numbersToWords.put(5: 'five');
    numbersToWords.put(6: 'six');
    numbersToWords.put(7: 'seven');
    numbersToWords.put(8: 'eight');
    numbersToWords.put(9: 'nine');
    numbersToWords.put(10: 'ten');
    numbersToWords.put(11: 'eleven');
    numbersToWords.put(12: 'twelve');
    numbersToWords.put(13: 'thirteen');
    numbersToWords.put(14: 'fourteen');
    numbersToWords.put(15: 'fifteen');
    numbersToWords.put(16: 'sixteen');
    numbersToWords.put(17: 'seventeen');
    numbersToWords.put(18: 'eighteen');
    numbersToWords.put(19: 'nineteen');
    numbersToWords.put(20: 'twenty');
    numbersToWords.put(30: 'thirty');
    numbersToWords.put(40: 'forty');
    numbersToWords.put(50: 'fifty');
    numbersToWords.put(60: 'sixty');
    numbersToWords.put(70: 'seventy');
    numbersToWords.put(80: 'eighty');
    numbersToWords.put(90: 'ninety');

    numbersToPlace.put(10,"ten");
    numbersToPlace.put(100,"hundred");
    numbersToPlace.put(1000,"thousand");
    numbersToPlace.put(1000000,"million");
    numbersToPlace.put(1000000000,"billion");
    numbersToPlace.put(1000000000000,"trillion");
    numbersToPlace.put(1000000000000000,"quadrillion");
    numbersToPlace.put(1000000000000000000,"quintillion");
  }

  public static void main(String[] args){
    initHashMaps();
  }

}
