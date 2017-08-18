package com.tb.coins;

/**
 * Program to write number of words in a given string is greater than or equal to given number
 *
 * @author tanmaybaid
 */
public class CountSpecificWordsInString {
  public static void main(String[] args) {
    // take a string input
    final String quote = "This is a string with some words!";

    // split into words
    final String[] word = quote.split(" ");
    final int len = word.length;
    final int num = 2;

    // to count words with greater size than number
    int count = 0;
    for (int i = 0; i < len; i++) {
      // if word length is greater than number increase the count
      if (word[i].length() >= num) {
        count++;
      }
    }

    // to print the count
    System.out.printf("Number of word greater than or equal to size %d are %d", num, count);
  }
}
