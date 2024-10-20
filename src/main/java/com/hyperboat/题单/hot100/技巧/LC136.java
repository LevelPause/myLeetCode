package com.hyperboat.题单.hot100.技巧;

/**
 * 136. 只出现一次的数字
 * <p>
 * https://leetcode.cn/problems/single-number/description/
 */
class LC136 {

  public int singleNumber(int[] nums) {
    int ans = nums[0];
    for (int num : nums) {
      ans ^= num;
    }
    return ans;
  }

}
