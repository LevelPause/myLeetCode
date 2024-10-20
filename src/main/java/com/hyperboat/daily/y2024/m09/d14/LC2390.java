package com.hyperboat.daily.y2024.m09.d14;

class LC2390 {

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
