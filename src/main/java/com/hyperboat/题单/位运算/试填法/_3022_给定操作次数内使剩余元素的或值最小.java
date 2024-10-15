package com.hyperboat.题单.位运算.试填法;

/*
 * https://leetcode.cn/problems/minimize-or-of-remaining-elements-using-operations/description/
 * */
public class _3022_给定操作次数内使剩余元素的或值最小 {

  class Solution {

    public int minOrAfterOperations(int[] nums, int k) {
      int max = 0;
      for (int x : nums) {
        max = Math.max(x, max);
      }
      int len = 32 - Integer.numberOfLeadingZeros(max);
      int mask = 0;
      for (int i = len - 1; i >= 0; i--) {
        mask ^= 1 << i;
        int curr = mask;
        int cnt = 0;
        for (int x : nums) {
          curr &= x & mask;
          if (curr != 0) {
            cnt++;
          } else {
            curr = mask;
          }
        }
        if (cnt > k) {
          mask ^= 1 << i;
        }
      }
      return ((1 << len) - 1) ^ mask;
    }
  }
}
