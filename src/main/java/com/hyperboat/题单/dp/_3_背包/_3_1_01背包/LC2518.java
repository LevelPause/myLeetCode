package com.hyperboat.题单.dp._3_背包._3_1_01背包;

/**
 * 2518. 好分区的数目
 *
 * https://leetcode.cn/problems/number-of-great-partitions/description/
 * */
class LC2518 {

  // 正难则反, 逆向思维01背包dp, 正向dp背包数量级太大, 考虑k比较小, 可以逆向考虑用全集- 不符合的方案(即两个分区中有坏分区)
  private static final int MOD = (int) 1e9 + 7;

  public int countPartitions(int[] nums, int k) {
    long sum = 0L;
    for (int num : nums) {
      sum += num;
    }
    // 注意当两个分区都是坏分区时, 数组和小于2k, 此时直接返回0即可
    // 不这样特判的话, 后续统计坏分区会出现重复统计, 导致结果错误
    // 特判之后坏分区出现的个数可能为0或1
    if (sum < k * 2L) {
      return 0;
    }
    int[] dp = new int[k];
    dp[0] = 1;
    int ans = 1;
    for (int num : nums) {
      ans = ans * 2 % MOD;
      for (int i = k - 1; i >= num; i--) {
        dp[i] = (dp[i] + dp[i - num]) % MOD;
      }
    }
    for (int i : dp) {
      ans = (ans - i * 2 % MOD + MOD) % MOD;
    }
    return ans;
  }

}
