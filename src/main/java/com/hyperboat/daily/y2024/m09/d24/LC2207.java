package com.hyperboat.daily.y2024.m09.d24;

/*
 * https://leetcode.cn/problems/maximize-number-of-subsequences-in-a-string/description/
 * */
public class LC2207 {

  class Solution {

    public long maximumSubsequenceCount(String text, String pattern) {
      char a = pattern.charAt(0);
      char b = pattern.charAt(1);
      long cnt = 0;
      int aCnt = 0;
      int bCnt = 0;
      for (char c : text.toCharArray()) {
        if (c == b) {
          bCnt++;
          cnt += aCnt;
        }
        if (c == a) {
          aCnt++;
        }
      }
      return cnt + Math.max(aCnt, bCnt);
    }
  }
}
