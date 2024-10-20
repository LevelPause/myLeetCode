package com.hyperboat.竞赛.双周赛141;

import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.cn/contest/biweekly-contest-141/problems/construct-the-minimum-bitwise-array-ii/description/
 * */
class _Q2_构造最小位运算数组II {

  class Solution {

    public int[] minBitwiseArray(List<Integer> nums) {
      int n = nums.size();
      int[] ans = new int[n];
      Arrays.fill(ans, -1);
      for (int i = 0; i < nums.size(); i++) {
        int x = nums.get(i);
        int len = 32 - Integer.numberOfLeadingZeros(x);
        int bitCount = Integer.bitCount(x);
        if (len == bitCount) {
          ans[i] = x >> 1;
        } else if (x > 2) {
          ans[i] = x - 1;
        }
      }
      return ans;
    }
  }
}
