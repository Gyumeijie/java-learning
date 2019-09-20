package math;

import java.math.BigInteger;

public class BigIntegerDemo {
   public static void main(String[] args) {
      BigInteger bigIntegerOne = new BigInteger("1000");
      BigInteger bigIntegerTwo = new BigInteger("50");

      // Multiply
      System.out.println(bigIntegerOne.multiply(bigIntegerTwo));

      // Add
      System.out.println(bigIntegerOne.add(bigIntegerTwo));

      // Minus
      System.out.println(bigIntegerOne.add(bigIntegerTwo.negate()));
      System.out.println(bigIntegerOne.subtract(bigIntegerTwo));

      // Divide
      System.out.println(bigIntegerOne.divide(bigIntegerTwo));

      // Constructor with 16 radix
      BigInteger bigIntegerThree = new BigInteger("32", 16);
      System.out.println(bigIntegerThree);
      System.out.println(bigIntegerThree.toString(2));

      // Abs
      BigInteger bigIntegerFour = new BigInteger("-50");
      System.out.println(bigIntegerFour.abs());

      // Bits count
      BigInteger bigIntegerFive = new BigInteger("10000101", 2); // 3
      System.out.println(bigIntegerFive.bitCount());

      // Divider adn Remainder
      BigInteger bigIntegerSix = new BigInteger("21");
      BigInteger bigIntegerSeven = new BigInteger("5");
      BigInteger[] divideAndRemainder = bigIntegerSix.divideAndRemainder(bigIntegerSeven);
      System.out.println(divideAndRemainder[0] + " " + divideAndRemainder[1]); // 4 1
   }
}
