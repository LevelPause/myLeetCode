package com.hyperboat.题单.位运算.思维题;

import java.util.List;

/**
 * 2835. 使子序列的和等于目标的最少操作次数
 * <p>
 * https://leetcode.cn/problems/minimum-operations-to-form-subsequence-with-target-sum/description/
 */
class LC2835 {

  public int minOperations(List<Integer> nums, int target) {
    long s = 0;
    int[] cnt = new int[31];
    for (int x : nums) {
      s += x;
      cnt[Integer.numberOfTrailingZeros(x)]++;
    }
    if (s < target) {
      return -1;
    }
    int ans = 0, i = 0;
    s = 0;
    while ((1L << i) <= target) {
      s += (long) cnt[i] << i;
      long mask = (1L << ++i) - 1;
      if (s >= (target & mask)) {
        continue;
      }
      ans++; // 一定要找更大的数操作
      for (; cnt[i] == 0; i++) {
        ans++; // 还没找到，继续找更大的数
      }
    }
    return ans;
  }

}
