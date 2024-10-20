package com.hyperboat.竞赛.周赛420;

import java.util.Arrays;

/**
 * Q3. 使数组非递减的最少除法操作次数
 * <p>
 * https://leetcode.cn/contest/weekly-contest-420/problems/minimum-division-operations-to-make-array-non-decreasing/description/
 */
class Q3 {

  static final int MAX = 1000_000 + 5;
  static boolean[] flags = new boolean[MAX + 1];

  static {
    int[] prime = new int[MAX];
    int k = 0;
    for (int i = 2; i < MAX + 1; i++) {
      if (!flags[i]) {
        prime[k++] = i;
      }
      for (int index = 0; index < k && i * prime[index] <= MAX; index++) {
        flags[i * prime[index]] = true;
        if (i % prime[index] == 0) {
          break;
        }
      }
    }
  }

  public int minOperations(int[] nums) {
    var n = nums.length;
    var ans = 0;
    System.out.println(Arrays.toString(flags));
    for (int i = n - 2; i >= 0; i--) {

      while (nums[i] > nums[i + 1]) {
        System.out.println(nums[i]);
        if (flags[nums[i]]) {
          return -1;
        }
        nums[i] = findMaxFactor(nums[i]);
        ans++;
      }
    }

    return ans;
  }

  private int findMaxFactor(int num) {
    var x = num / 2;
    while (num % x != 0) {
      x--;
    }
    return x;
  }
}
