package com.hyperboat.题单.位运算.思维题;

/**
 * 2571. 将整数减少到零需要的最少操作数
 * <p>
 * https://leetcode.cn/problems/minimum-operations-to-reduce-an-integer-to-0/
 */
class LC2571 {

  public int minOperations(int n) {
    var ans = 0;
    while ((n & (n - 1)) > 0) {
      var lowBit = n & -n;
      if ((lowBit << 1 & n) > 0) {
        n += lowBit;
      } else {
        n -= lowBit;
      }
      ans++;
    }
    return ans + 1;
  }

}
