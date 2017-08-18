package com.tb.coins;

/**
 * Program to check if two Strings are Anagrams or not!!!
 *
 * @author tanmaybaid
 */
public class Anagram {
  public static void isAnagram(final String string1, final String string2) {
    final StringBuffer s1 = new StringBuffer(string1);
    final StringBuffer s2 = new StringBuffer(string2);
    if (s1.length() == s2.length()) {
      int len = 0;
      for (int i = 0; i < s1.length(); i++) {
        for (int j = 0; j < s2.length(); j++) {
          if (s1.charAt(i) == s2.charAt(j)) {
            len++;
            s2.deleteCharAt(j);
          }
        }
      }
      if (len == s1.length())
        System.out.println("Two strings are Anagrams");
      else
        System.out.println("Strings are not anagrams");
    } else
      System.out.println("Strings are not anagrams");
  }

  public static void main(final String[] args) {
    final String s1 = "papa";
    final String s2 = "appa";

    System.out.println("Checking if two strings are anagrams--");
    isAnagram(s1, s2);
  }
}
