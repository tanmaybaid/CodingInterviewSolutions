package com.tb.coins;

import java.util.stream.IntStream;

public class FindAllPrimeInRange {
  public static void main(String[] args) {
    int start = 1;
    int end = 1000;

    IntStream.range(start, end).filter(n -> isPrime(n)).forEach(System.out::println);
  }

  private static boolean isPrime(final int n) {
    if ((n > 2 && (n & 1) == 0) // check is it even
        || n <= 1 // check for negative
        || (n > 3 && (n % 3 == 0))) { // check for 3 divisible
      return false;
    }

    for (int i = 3; (i + 2) <= Math.sqrt(n); i = i + 6) {
      if (n % (i + 2) == 0 || n % (i + 4) == 0) {
        return false;
      }
    }
    return true;
  }
}
