package com.tb.coins;

public class LuckyNumber {
  public static void main(String[] args) {
    int number = 23411;
    int sum = sum(number);

    System.out.println(sum);
  }

  private static int sum(final int n) {
    return n == 0 ? 0 : n % 10 + sum(n / 10);
  }
}
