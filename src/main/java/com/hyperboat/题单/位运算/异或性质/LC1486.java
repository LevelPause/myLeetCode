package com.hyperboat.题单.位运算.异或性质;

/**
 * 1486. 数组异或操作
 * <p>
 * https://leetcode.cn/problems/xor-operation-in-an-array/description/
 */
class LC1486 {

  public int xorOperation(int n, int start) {
    int ans = start;
    for (int i = 1; i < n; i++) {
      ans ^= start + i * 2;
    }
    return ans;
  }

}
