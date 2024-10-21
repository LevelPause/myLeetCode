package com.hyperboat.题单.位运算.基础;

/**
 * 2595. 奇偶位数
 * <p>
 * https://leetcode.cn/problems/number-of-even-and-odd-bits/description/
 */
class LC2595 {

  public int[] evenOddBit(int n) {
    int even = 0;
    int odd = 0;
    boolean isOdd = false;
    while (n > 0) {
      if ((n & 1) == 1) {
        if (isOdd) {
          odd++;
        } else {
          even++;
        }
      }

      isOdd = !isOdd;
      n >>= 1;
    }
    return new int[]{even, odd};
  }

}
