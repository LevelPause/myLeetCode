package com.hyperboat.竞赛.双周赛141;

import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.cn/contest/biweekly-contest-141/problems/construct-the-minimum-bitwise-array-i/description/
 * */
public class _Q1_构造最小位运算数组I {

  class Solution {

    public int[] minBitwiseArray(List<Integer> nums) {
      int n = nums.size();
      int[] ans = new int[n];
      Arrays.fill(ans, -1);
      for (int i = 0; i < nums.size(); i++) {
        int x = nums.get(i);
        int len = 32 - Integer.numberOfLeadingZeros(x);
        for (int j = 0; j <= len; j++) {
          int mask = 1 << j;
          if (x > 2 && (x & mask) == 0) {
            x -= mask >> 1;
            ans[i] = x;
            break;
          }
        }
      }
      return ans;
    }
  }

}
