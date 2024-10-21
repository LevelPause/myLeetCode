package com.hyperboat.题单.位运算.思维题;

/**
 * 2568. 最小无法得到的或值
 * <p>
 * https://leetcode.cn/problems/minimum-impossible-or/description/
 */
class LC2568 {

  public int minImpossibleOR(int[] nums) {
    var or = 0;
    for (var x : nums) {
      if ((x & (x - 1)) == 0) {
        or |= x;
      }
    }
    or = ~or;
    return or & -or;
  }

}
