package com.hyperboat.题单.位运算.其他;

/**
 * 982. 按位与为零的三元组
 * <p>
 * https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/description/
 */
class LC982 {

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
