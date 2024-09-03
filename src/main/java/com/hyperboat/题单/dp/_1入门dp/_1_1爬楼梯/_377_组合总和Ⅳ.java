package com.hyperboat.题单.dp._1入门dp._1_1爬楼梯;

/*
 * https://leetcode.cn/problems/combination-sum-iv/description/
 * */
public class _377_组合总和Ⅳ {

  class Solution {

    public int combinationSum4(int[] nums, int target) {
      int[] dp = new int[target + 1];
      dp[0] = 1;
      for (int i = 1; i <= target; i++) {
        for (int num : nums) {
          if (num<i){
            dp[i]+=dp[i-num];
          }
        }
      }
      return dp[target];
    }
  }
}
