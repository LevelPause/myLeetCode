package com.hyperboat.竞赛.双周赛140;

/*
 * https://leetcode.cn/contest/biweekly-contest-140/problems/minimum-element-after-replacement-with-digit-sum/description/
 * */
class _Q1_替换为数位和以后的最小元素 {

  class Solution {

    public int minElement(int[] nums) {
      int ans = Integer.MAX_VALUE;
      for (int x : nums) {
        int sum = 0;
        while (x > 0) {
          sum += x % 10;
          x /= 10;
        }
        ans = Math.min(ans, sum);
      }
      return ans;
    }
  }
}
