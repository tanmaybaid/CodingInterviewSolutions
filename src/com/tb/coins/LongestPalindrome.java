package com.tb.coins;

public class LongestPalindrome {

  public static void main(String[] args) {
    final String input = "bananas";

    final String longestPalindrome = getLongestPalindrome(input);

    System.out.println(longestPalindrome);
  }

  private static String getLongestPalindrome(final String input) {
    String longestPalindrome = "";

    for (int start = 0; start < input.length(); start++) {
      for (int end = input.length() - 1; end > start; end--) {
        final String subString = input.substring(start, end + 1);
        final boolean isPalindrome = isPalindrome(subString);

        if (isPalindrome && longestPalindrome.length() < subString.length()) {
          longestPalindrome = subString;
        }
      }
    }
    return longestPalindrome;
  }

  private static boolean isPalindrome(final String input) {
    for (int start = 0, end = input.length() - 1; start <= input.length() / 2; start++, end--) {
      if (input.charAt(start) != input.charAt(end)) {
        return false;
      }
    }
    return true;
  }
}
