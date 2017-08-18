package com.tb.coins;

import java.util.Arrays;

public class TwoSum {

  public static void main(String[] args) {
    final int[] nums = new int[] {112, 13, 14, 15, 15156, 15, 51, 12, 2, 7};
    final int target = 9;

    final int[] indices = twoSum(nums, target);
    System.out.println(Arrays.toString(indices));
  }

  private static int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (target == nums[i] + nums[j]) {
          return new int[] {i, j};
        }
      }
    }
    return null;
  }
}
