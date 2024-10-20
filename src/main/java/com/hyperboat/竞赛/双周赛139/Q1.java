package com.hyperboat.竞赛.双周赛139;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.cn/problems/find-indices-of-stable-mountains/description/
 * */
class Q1 {

  class Solution {

    public List<Integer> stableMountains(int[] height, int threshold) {
      int n = height.length;
      List<Integer> ans = new ArrayList<>();
      for (int i = 1; i < n; i++) {
        if (height[i - 1] > threshold) {
          ans.add(i);
        }
      }
      return ans;
    }
  }
}
