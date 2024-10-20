package com.hyperboat.题单.hot100.普通数组;

/**
 * 41. 缺失的第一个正数
 * <p>
 * https://leetcode.cn/problems/first-missing-positive/?envType=study-plan-v2&envId=top-100-liked
 */
class LC41 {

  public int firstMissingPositive(int[] nums) {
    return byHash(nums);
  }

  public int byHash(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (nums[i] <= 0) {
        nums[i] = n + 1;
      }
    }
    for (int i = 0; i < n; i++) {
      int x = Math.abs(nums[i]);
      if (x <= n) {
        nums[x - 1] = -Math.abs(nums[x - 1]);
      }
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }
    return n + 1;

  }

  public int bySwap(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
        swap(nums, i, nums[i] - 1);
      }
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return n + 1;

  }

  public void swap(int[] nums, int a, int b) {
    int t = nums[a];
    nums[a] = nums[b];
    nums[b] = t;
  }
}
