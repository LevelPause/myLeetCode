package com.hyperboat.题单.位运算.基础;

/**
 * 342. 4的幂
 * <p>
 * https://leetcode.cn/problems/power-of-four/description/
 */
class LC342 {

  public boolean isPowerOfFour(int n) {
    return n > 0 && (n & -n) == n && (32 - Integer.numberOfLeadingZeros(n)) % 2 == 1;
  }

}
