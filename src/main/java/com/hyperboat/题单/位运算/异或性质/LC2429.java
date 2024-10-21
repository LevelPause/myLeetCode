package com.hyperboat.题单.位运算.异或性质;

/**
 * 2429. 最小异或
 * <p>
 * https://leetcode.cn/problems/minimize-xor/description/
 */
class LC2429 {

  public int minimizeXor(int num1, int num2) {
    int bitLen1 = Integer.bitCount(num1);
    int bitLen2 = Integer.bitCount(num2);
    if (bitLen1 == bitLen2) {
      return num1;
    }
    while (bitLen1 < bitLen2) {
      num1 |= num1 + 1;
      bitLen1++;
    }
    while (bitLen1 > bitLen2) {
      num1 &= num1 - 1;
      bitLen1--;
    }
    return num1;
  }

}
