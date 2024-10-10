package com.hyperboat.竞赛.周赛418;

import java.util.Arrays;

/*
 * https://leetcode.cn/contest/weekly-contest-418/problems/maximum-possible-number-by-binary-concatenation/description/
 * */
public class Q1_连接二进制表示可形成的最大数值 {

  class Solution {

    public int maxGoodNumber(int[] nums) {
      Integer[] arr = new Integer[]{nums[0], nums[1], nums[2]};
      Arrays.sort(arr, (a, b) -> {
        int lenA = 32 - Integer.numberOfLeadingZeros(a);
        int lenB = 32 - Integer.numberOfLeadingZeros(b);
        return (b << lenA | a) - (a << lenB | b);
      });

      int ans = 0;
      for (int x : arr) {
        int lenX = 32 - Integer.numberOfLeadingZeros(x);
        ans = ans << lenX | x;
      }
      return ans;
    }
  }
}
