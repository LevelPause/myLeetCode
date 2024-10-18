package com.hyperboat.daily.y2024.m08.d03;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/maximum-points-inside-the-square/description/
 * */
public class LC3143 {

  public int maxPointsInsideSquare(int[][] points, String s) {
    int[] minArr = new int[26];
    Arrays.fill(minArr, Integer.MAX_VALUE);
    int min2 = Integer.MAX_VALUE;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int x = points[i][0];
      int y = points[i][0];
      int d = Math.max(Math.abs(x), Math.abs(y));
      if (d < minArr[c - 'a']) {
        min2 = Math.min(minArr[c - 'a'], min2);
        minArr[c - 'a'] = d;
      } else {
        min2 = Math.min(d, min2);
      }
    }
    int res = 0;
    for (int d : minArr) {
      if (d < min2) {
        res++;
      }
    }
    return res;
  }
}
