package com.tb.coins;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.IntStream;

import com.google.common.collect.ImmutableMap;

/**
 * WAP to sort array that contains 0s and 1s.
 * WAP to sort a binary array.
 *
 * @author tanmaybaid
 *
 */
public class SortBinaryArray {
  public static void main(String[] args) {
    System.out.println("\nTest 'keepCount' approach");
    test((unsorted) -> sort_keepCount(unsorted));

    System.out.println("\nTest 'putInNewArray' approach");
    test((unsorted) -> sort_putInNewArray(unsorted));

    System.out.println("\nTest 'inplace' approach");
    test((unsorted) -> sort_inplace(unsorted));
  }

  /**
   * Approach 1:
   * <ol>
   *   <li>Loop through input array and maintain a count of zeroes and ones.</li>
   *   <li>Create new array to store sorted values</li>
   *   <li>Put 0s in new array in the first n indexes, where n is the count of zeroes</li>
   *   <li>Put 1s in new array starting from previous steps index upto n indexes, where n is the count of ones</li>
   * </ol>
   *
   * @param unsorted input unsorted array
   * @return sorted array
   */
  private static int[] sort_keepCount(final int[] unsorted) {
    // If input is null or empty return input.
    if (unsorted == null || unsorted.length == 0) {
      return unsorted;
    }

    // Validate if input contains anything other than 0s and 1s.
    IntStream.of(unsorted).filter(i -> i != 0 && i != 1).findAny().ifPresent((i) -> {
      throw new IllegalArgumentException("Invalid input. Array contains: " + i);
    });

    // loop through the given array and count number of zeroes.
    final int countZero = Math.toIntExact(IntStream.of(unsorted).filter(i -> i == 0).count());

    final int[] sorted = new int[unsorted.length];

    // put countZero 0s from beginning of array
    IntStream.range(0, countZero).forEach(i -> sorted[i] = 0);

    // put 1s from countZero'th index of array
    IntStream.range(countZero, sorted.length).forEach(i -> sorted[i] = 1);

    return sorted;
  }

  private static int[] sort_putInNewArray(final int[] unsorted) {
    // If input is null or empty return input.
    if (unsorted == null || unsorted.length == 0) {
      return unsorted;
    }

    // Validate if input contains anything other than 0s and 1s.
    IntStream.of(unsorted).filter(i -> i != 0 && i != 1).findAny().ifPresent((i) -> {
      throw new IllegalArgumentException("Invalid input. Array contains: " + i);
    });

    final int[] sorted = new int[unsorted.length];
    int left = 0; // left pointer
    int right = unsorted.length - 1; // right pointer

    // loop through the given array
    for (int i = 0; i < unsorted.length; i++) {
      if (unsorted[i] == 1) {
        // if element is 1, put it at the 'right' index of new array and decrement 'right' pointer.
        sorted[right--] = unsorted[i];
      } else { // we have already validated that the input contains only 0s and 1s.
        // if element is 0, put it at the 'left' index of new array and increment 'left' pointer.
        sorted[left++] = unsorted[i];
      }
    }
    return sorted;
  }

  private static int[] sort_inplace(final int[] input) {
    // If input is null or empty return input.
    if (input == null || input.length == 0) {
      return input;
    }

    // Validate if input contains anything other than 0s and 1s.
    IntStream.of(input).filter(i -> i != 0 && i != 1).findAny().ifPresent((i) -> {
      throw new IllegalArgumentException("Invalid input. Array contains: " + i);
    });

    int left = 0; // left pointer
    int right = input.length - 1; // right pointer

    // run until left pointer crosses right
    while (left < right) {
      // increment left pointer until it hits 1 or crosses right pointer
      while (left < right && input[left] == 0) {
        left++;
      }

      // decrement right pointer until it hits 0 or crosses left pointer
      while (left < right && input[right] == 1) {
        right--;
      }

      // swap element on right pointer with the on left pointer
      int temp = input[right];
      input[right] = input[left];
      input[left] = temp;

      // Not using following 1-liner that does not use temp variable as its not readable!
      // input[right] = input[right] ^ input[left] ^ (input[left] = input[right]);
    }

    return input;
  }

  /*
   * Tests!!!
   */

  private static void test(final Function<int[], int[]> sort) {
    final Map<int[], int[]> testCases = ImmutableMap.<int[], int[]>builder()
        .put(new int[] {0, 0, 0, 0, 1, 1, 1, 1, 1}, new int[] {0, 0, 0, 0, 1, 1, 1, 1, 1})
        .put(new int[] {1, 1, 1, 1, 1, 0, 0, 0, 0}, new int[] {0, 0, 0, 0, 1, 1, 1, 1, 1})
        .put(new int[] {1, 0, 1, 0, 1, 0, 1, 0, 1}, new int[] {0, 0, 0, 0, 1, 1, 1, 1, 1})
        .put(new int[] {0, 1, 0, 1, 0, 1, 0, 1, 0}, new int[] {0, 0, 0, 0, 0, 1, 1, 1, 1})
        .put(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1}, new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1})
        .put(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0}, new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0})
        .put(new int[] {}, new int[] {})
        .build();

    for (final Entry<int[], int[]> testCase : testCases.entrySet()) {
      final int[] result = sort.apply(testCase.getKey());
      final boolean isPassed = Arrays.equals(result, testCase.getValue());

      System.out.println(String.format("Test: %s. Expected: %s. Actual: %s. Passed? %s.",
          print(testCase.getKey()), print(testCase.getValue()), print(result), isPassed));
    }
  }

  private static String print(int[] array) {
    return Arrays.toString(array);
  }
}
