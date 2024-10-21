package com.hyperboat.题单.位运算.其他;

/**
 * 136. 只出现一次的数字
 * <p>
 * https://leetcode.cn/problems/single-number/description/
 */
class LC136 {

  public int singleNumber(int[] nums) {
    var xor = 0;
    for (int x : nums) {
      xor ^= x;
    }
    return xor;
  }

}
