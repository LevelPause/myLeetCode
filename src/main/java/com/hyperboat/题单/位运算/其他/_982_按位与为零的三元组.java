package com.hyperboat.题单.位运算.其他;

/**
 * https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/description/
 */
public class _982_按位与为零的三元组 {

  class Solution {

    public int countTriplets(int[] nums) {
      var cnt = new int[1 << 16];
      for (int x : nums) {
        for (int y : nums) {
          cnt[x & y]++;
        }
      }
      var ans = 0;
      for (int k : nums) {
        k ^= 0xffff;
        int m = k;
        do {
          ans += cnt[m];
          m = (m - 1) & k;
        } while (m != k);
      }
      return ans;
    }
  }
}
