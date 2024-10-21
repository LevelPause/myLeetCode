package com.hyperboat.题单.位运算.基础;

/**
 * 338. 比特位计数
 *
 * https://leetcode.cn/problems/counting-bits/description/
 * */
class LC338 {

  public int[] countBits(int n) {
    int[] ans = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      ans[i] = ans[i >> 1] + (i & 1);
    }
    return ans;
  }

}
