package com.hyperboat.hot100.技巧;

public class _136_只出现一次的数字 {

  class Solution {

    public int singleNumber(int[] nums) {
      int ans = nums[0];
      for (int num : nums) {
        ans ^= num;
      }
      return ans;
    }
  }
}
