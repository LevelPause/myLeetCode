package com.hyperboat.题单.位运算.拆位法贡献法;

/*
 * https://leetcode.cn/problems/total-hamming-distance/description/
 * */
public class _477_汉明距离总和 {

  class Solution {

    public int totalHammingDistance(int[] nums) {
      int max = 0;
      for (int x : nums) {
        max = Math.max(x, max);
      }
      int highestBit = 31 - Integer.numberOfLeadingZeros(max);
      int n = nums.length;
      int ans = 0;
      for (int i = 0; i <= highestBit; i++) {
        int cnt = 0;
        for (int x : nums) {
          cnt += (x >> i) & 1;
        }
        ans += cnt * (n - cnt);
      }
      return ans;
    }
  }
}
