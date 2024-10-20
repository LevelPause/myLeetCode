package com.hyperboat.daily.y2024.m09.d15;

import java.util.List;

/*
 * https://leetcode.cn/problems/points-that-intersect-with-cars/
 * */
class LC2848 {

  class Solution {

    public int numberOfPoints(List<List<Integer>> nums) {
      int[] diff = new int[102];
      for (List<Integer> num : nums) {
        diff[num.get(0)]++;
        diff[num.get(1) + 1]--;
      }
      int ans = 0;
      int sum = 0;
      for (int i : diff) {
        sum += i;
        if (sum > 0) {
          ans++;
        }
      }
      return ans;
    }
  }
}
