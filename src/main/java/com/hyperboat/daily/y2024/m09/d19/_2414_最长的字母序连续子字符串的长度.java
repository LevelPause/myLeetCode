package com.hyperboat.daily.y2024.m09.d19;

/*
 * https://leetcode.cn/problems/length-of-the-longest-alphabetical-continuous-substring/
 * */
public class _2414_最长的字母序连续子字符串的长度 {

  class Solution {

    public int longestContinuousSubstring(String s) {
      int len = 1, ans = 1, n = s.length();
      char[] c = s.toCharArray();
      for (int i = 1; i < n; i++) {
        if (c[i - 1] + 1 == c[i]) {
          len++;
        } else {
          len = 1;
        }
        ans = Math.max(len, ans);
      }
      return ans;
    }
  }
}
