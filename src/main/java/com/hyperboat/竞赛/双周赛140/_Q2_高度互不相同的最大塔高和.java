package com.hyperboat.竞赛.双周赛140;

import java.util.Arrays;

/*
 * https://leetcode.cn/contest/biweekly-contest-140/problems/maximize-the-total-height-of-unique-towers/description/
 * */
class _Q2_高度互不相同的最大塔高和 {

  class Solution {

    public long maximumTotalSum(int[] maximumHeight) {
      int n = maximumHeight.length;
      Arrays.sort(maximumHeight);
      long ans = 0L;
      int min = maximumHeight[n - 1];
      for (int i = n - 1; i >= 0; i--) {
        if (min == 0) {
          return -1;
        }
        min = Math.min(maximumHeight[i], min);
        ans += min;
        min--;
      }
      return ans;
    }
  }
}
