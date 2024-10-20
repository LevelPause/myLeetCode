package com.hyperboat.题单.位运算.基础;

/*
 * https://leetcode.cn/problems/find-the-k-or-of-an-array/description/
 * */
class _2917_找出数组中的Kor值 {

  class Solution {

    public int findKOr(int[] nums, int k) {
      int ans = 0;
      for (int i = 0; i < 32; i++) {
        int mask = 1 << i;
        int cnt = 0;
        for (int x : nums) {
          if ((mask & x) == mask) {
            cnt++;
          }
          if (cnt >= k) {
            ans |= mask;
            break;
          }
        }
      }
      return ans;
    }
  }
}
