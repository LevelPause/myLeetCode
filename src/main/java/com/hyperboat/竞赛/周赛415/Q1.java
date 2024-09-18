package com.hyperboat.竞赛.周赛415;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.cn/contest/weekly-contest-415/problems/the-two-sneaky-numbers-of-digitville/
 * */
public class Q1 {

  class Solution {

    public int[] getSneakyNumbers(int[] nums) {
      int[] ans = new int[2];
      int index = 0;
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
        if (set.contains(nums[i])) {
          ans[index++] = nums[i];
        } else {
          set.add(nums[i]);
        }
      }
      return ans;
    }
  }
}
