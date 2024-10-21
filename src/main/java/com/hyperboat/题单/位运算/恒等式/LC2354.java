package com.hyperboat.题单.位运算.恒等式;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 2354. 优质数对的数目
 * <p>
 * https://leetcode.cn/problems/number-of-excellent-pairs/description/
 */
class LC2354 {

  public long countExcellentPairs(int[] nums, int k) {
    return On_U(nums, k);
  }

  /*
   * 时间复杂度O(n+U^2) U为int的最大二进制长度
   * */
  private long On_U2(int[] nums, int k) {
    var set = new HashSet<Integer>();
    var cnt = new int[30];
    for (int x : nums) {
      if (set.add(x)) {
        int c = Integer.bitCount(x);
        cnt[c]++;
      }
    }
    var ans = 0L;
    var s = 0L;
    for (int i = k; i < 30; i++) {
      s += cnt[i];
    }
    for (int x = 0; x < 30; x++) {
      ans += s * cnt[x];
      var y = k - 1 - x;
      if (0 <= y && y < 30) {
        s += cnt[y];
      }
    }
    return ans;
  }

  /*
   * 时间复杂度O(n+U^2) U为int的最大二进制长度
   * */
  private long On_U(int[] nums, int k) {
    var set = new HashSet<Integer>();
    var cnt = new HashMap<Integer, Integer>();
    for (int x : nums) {
      if (set.add(x)) {
        int c = Integer.bitCount(x);
        cnt.merge(c, 1, Integer::sum);
      }
    }
    var ans = 0L;
    for (var a : cnt.entrySet()) {
      for (var b : cnt.entrySet()) {
        if (a.getKey() + b.getKey() >= k) {
          ans += (long) a.getValue() * b.getValue();
        }
      }
    }
    return ans;
  }

}
