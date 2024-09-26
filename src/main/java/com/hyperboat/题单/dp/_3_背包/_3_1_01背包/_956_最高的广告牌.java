package com.hyperboat.题单.dp._3_背包._3_1_01背包;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/tallest-billboard/description/
 * */
public class _956_最高的广告牌 {

  //两种枚举思路, 一种是枚举差值时的最大公共高度, 一种时枚举差值时的最大和(差值为0时, 最大和的一半就是结果)
  class Solution {

    public int tallestBillboard(int[] rods) {
      return maxCommon(rods);
    }

    private int maxCommon(int[] rods) {
      int sum = 0;
      for (int rod : rods) {
        sum += rod;
      }
      int n = rods.length;
      // dp[i][j]表示前i个数挑选出一些分成两堆, 两堆高度的差值为j时的最大公共高度
      // 可用滚动数组优化为一维dp
      int[] dp = new int[sum + 1];
      Arrays.fill(dp, -1);
      dp[0] = 0;
      int preSum = 0;

      for (int rod : rods) {
        preSum += rod;
        int[] last = dp.clone();
        for (int j = 0; j <= preSum; j++) {
          if (last[j] < 0) {
            continue;
          }
          // 抛弃rod, 差值不变
          // dp[j] = last[j];
          // 将rod放到较高的那一堆, 差值增加rod
          int k = j + rod;
          dp[k] = Math.max(dp[k], last[j]);
          // 将rod放到较矮的那一堆, 差值变为｜j-rod｜(可能变大也可能变小)
          int p = Math.abs(j - rod);
          int min = Math.min(j, rod);
          dp[p] = Math.max(dp[p], last[j] + min);
        }
      }
      return dp[0];
    }

    private int maxSum(int[] rods) {
      int sum = 0;
      for (int rod : rods) {
        sum += rod;
      }
      int n = rods.length;
      // dp[i][j]表示前i个数的组成的差值为j时的高度和
      int[][] dp = new int[n + 1][sum + 1];
      for (int i = 0; i <= n; i++) {
        Arrays.fill(dp[i], -1);
        dp[i][0] = 0;
      }
      int preSum = 0;
      for (int i = 1; i < n; i++) {
        int rod = rods[i - 1];
        preSum += rod;
        for (int j = 0; j <= preSum; j++) {
          if (dp[i - 1][j] < j) {
            continue;
          }
          // 抛弃rod, 差值不变
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
          // 将rod放到较高的那一堆, 差值增加rod
          int k = j + rod;
          dp[i][k] = Math.max(dp[i][k], dp[i - 1][j] + rod);
          // 将rod放到较矮的那一堆, 差值变为｜j-rod｜(可能变大也可能变小)
          int p = Math.abs(j - rod);
          dp[i][p] = Math.max(dp[i][p], dp[i - 1][j] + rod);
        }
      }
      return dp[n][0] / 2;
    }
  }
}
