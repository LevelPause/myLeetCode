package com.hyperboat.daily.y2024.m09.d15;

import java.util.List;

/*
 * https://leetcode.cn/problems/points-that-intersect-with-cars/
 * */
public class _2848_与车相交的点 {

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
