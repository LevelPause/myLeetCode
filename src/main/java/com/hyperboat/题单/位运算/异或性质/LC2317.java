package com.hyperboat.题单.位运算.异或性质;

/**
 * 2317. 操作后的最大异或和
 * <p>
 * https://leetcode.cn/problems/maximum-xor-after-operations/description/
 */
class LC2317 {

  public int maximumXOR(int[] nums) {
    int ans = 0;
    for (int x : nums) {
      ans |= x;
    }
    return ans;
  }

}
