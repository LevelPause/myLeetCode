package com.hyperboat.竞赛.周赛412;

public class Q1_K次乘运算后的最终数组I {

  class Solution {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
      int n = nums.length;
      for (int i = 0; i < k; i++) {
        int minINdex = 0;
        for (int j = 1; j < n; j++) {
          if (nums[minINdex] > nums[j]) {
            minINdex = j;
          }
        }
        nums[minINdex] = (int) ((nums[minINdex] * multiplier) % (1e9 + 7));
      }
      return nums;
    }
  }
}
