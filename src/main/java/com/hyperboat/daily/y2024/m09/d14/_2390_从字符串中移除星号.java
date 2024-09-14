package com.hyperboat.daily.y2024.m09.d14;

public class _2390_从字符串中移除星号 {

  class Solution {

    public String removeStars(String s) {
      StringBuilder sb = new StringBuilder(s.length());
      for (char c : s.toCharArray()) {
        if (c != '*') {
          sb.append(c);
        } else {
          sb.deleteCharAt(sb.length() - 1);
        }
      }
      return sb.toString();
    }
  }
}
