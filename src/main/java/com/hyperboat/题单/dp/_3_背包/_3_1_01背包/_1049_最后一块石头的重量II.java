package com.hyperboat.题单.dp._3_背包._3_1_01背包;

/*
 * https://leetcode.cn/problems/last-stone-weight-ii/description/
 * */
public class _1049_最后一块石头的重量II {

  // 这里01背包的思想是选出一堆石头使他们的和趋近于总和的一半, 这样去抵消另一半剩下的就最小了
  // 所以这里的背包容量为sum/2, 结果为 sum-2*dp[sum/2]
  class Solution {

    public int lastStoneWeightII(int[] stones) {
      int sum = 0;
      for (int stone : stones) {
        sum += stone;
      }
      int half = sum / 2;
      int[] dp = new int[half + 1];
      for (int stone : stones) {
        for (int i = half; i >= stone; i--) {
          dp[i] = Math.max(dp[i], dp[i - stone] + stone);
        }
      }
      return Math.abs(sum - 2 * dp[half]);
    }
  }
}
