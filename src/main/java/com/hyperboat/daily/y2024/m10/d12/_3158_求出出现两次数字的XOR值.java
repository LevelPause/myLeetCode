package com.hyperboat.daily.y2024.m10.d12;

/*
 * https://leetcode.cn/problems/find-the-xor-of-numbers-which-appear-twice/description/
 * */
public class _3158_求出出现两次数字的XOR值 {

  class Solution {

    public int duplicateNumbersXOR(int[] nums) {
      long vis = 0L;
      int ans = 0;
      for (int x : nums) {
        if ((vis >> x & 1) == 1) {
          ans ^= x;
        }
        vis |= 1L << x;
      }
      return ans;
    }
  }
}
