package com.hyperboat.题单.位运算.异或性质;

/**
 * 1720. 解码异或后的数组
 * <p>
 * https://leetcode.cn/problems/decode-xored-array/description/
 */
class LC1720 {

  public int[] decode(int[] encoded, int first) {
    int n = encoded.length;
    int[] ans = new int[n + 1];
    ans[0] = first;
    for (int i = 1; i <= n; i++) {
      ans[i] = ans[i - 1] ^ encoded[i - 1];
    }
    return ans;
  }

}
