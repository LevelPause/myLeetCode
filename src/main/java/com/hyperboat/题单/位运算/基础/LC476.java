package com.hyperboat.题单.位运算.基础;

/**
 * 476. 数字的补数
 * <p>
 * https://leetcode.cn/problems/number-complement/description/
 */
class LC476 {

  public int findComplement(int num) {
    return ~num & ((Integer.highestOneBit(num) << 1) - 1);
  }

}
