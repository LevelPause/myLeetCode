package com.hyperboat.题单.位运算.思维题;

/**
 * 1558. 得到目标数组的最少函数调用次数
 * <p>
 * https://leetcode.cn/problems/minimum-numbers-of-function-calls-to-make-target-array/description/
 */
class LC1558 {

  public int minOperations(int[] nums) {
    var max = 0;
    var bitCount = 0;
    for (int x : nums) {
      max = Math.max(max, x);
      bitCount += Integer.bitCount(x);
    }
    if (max == 0) {
      return 0;
    }
    return bitCount + (31 - Integer.numberOfLeadingZeros(max));
  }

}
