package com.hyperboat.题单.位运算.与或性质;

/**
 * 2980. 检查按位或是否存在尾随零
 * <p>
 * https://leetcode.cn/problems/check-if-bitwise-or-has-trailing-zeros/description/
 */
class LC2980 {

  public boolean hasTrailingZeros(int[] nums) {
    int cnt = 0;
    for (int x : nums) {
      if ((x & 1) == 0) {
        cnt++;
      }
      if (cnt > 1) {
        return true;
      }
    }
    return false;
  }

}
