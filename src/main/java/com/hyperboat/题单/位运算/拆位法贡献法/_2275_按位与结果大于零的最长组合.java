package com.hyperboat.题单.位运算.拆位法贡献法;

/*
 * https://leetcode.cn/problems/largest-combination-with-bitwise-and-greater-than-zero/description/
 * */
class _2275_按位与结果大于零的最长组合 {

  class Solution {

    public int largestCombination(int[] candidates) {
      int ans = 0;
      for (int i = 0; i < 24; i++) {
        int cnt = 0;
        for (int x : candidates) {
          cnt += x >> i & 1;
        }
        ans = Math.max(ans, cnt);
      }
      return ans;
    }
  }
}
