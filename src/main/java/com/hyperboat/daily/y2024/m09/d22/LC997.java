package com.hyperboat.daily.y2024.m09.d22;

/*
 * https://leetcode.cn/problems/find-the-town-judge/submissions/566856174/
 * */
public class LC997 {

  class Solution {

    public int findJudge(int n, int[][] trust) {
      int[] degree = new int[n + 1];
      int max = 1;
      for (int[] row : trust) {
        degree[row[0]] -= 1;
        degree[row[1]] += 1;
        if (degree[row[1]] > degree[max]) {
          max = row[1];
        }
      }
      if (degree[max] == n - 1) {
        return max;
      } else {
        return -1;
      }
    }
  }
}
