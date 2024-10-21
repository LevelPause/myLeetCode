package com.hyperboat.题单.位运算.基础;

/**
 * 231. 2的幂
 * <p>
 * https://leetcode.cn/problems/power-of-two/description/
 */
class LC231 {

  public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & -n) == n;
  }

}
