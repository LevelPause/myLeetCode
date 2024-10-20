package com.hyperboat.题单.dp._3_背包._3_3_多重背包;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2902. 和带限制的子多重集合的数目
 * <p>
 * https://leetcode.cn/problems/count-of-sub-multisets-with-bounded-sum/description/
 */
class LC2902 {

  private static final int MOD = (int) 1e9 + 7;

  public int countSubMultisets(List<Integer> nums, int l, int r) {

    Map<Integer, Integer> cnt = new HashMap<>();
    int total = 0;
    for (Integer num : nums) {
      total += num;
      cnt.merge(num, 1, Integer::sum);
    }
    if (l > total) {
      return 0;
    }
    r = Math.min(r, total);
    int[] dp = new int[r + 1];
    dp[0] = cnt.getOrDefault(0, 0) + 1;
    cnt.remove(0);
    int ans = 0;
    int sum = 0;
    for (int x : cnt.keySet()) {
      int count = cnt.get(x);
      sum = Math.min(sum + x * count, r);
      for (int j = x; j <= sum; j++) {
        dp[j] = (dp[j] + dp[j - x]) % MOD;
      }
      for (int i = sum; i >= (count + 1) * x; i--) {
        dp[i] = (dp[i] - dp[i - (count + 1) * x] + MOD) % MOD;
      }
    }
    for (int i = l; i <= r; i++) {
      ans = (ans + dp[i]) % MOD;
    }
    return ans;
  }


}
