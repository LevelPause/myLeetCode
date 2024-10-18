package com.hyperboat.daily.y2024.m09.d05;

public class LC3174 {

  class Solution {

    public String clearDigits(String s) {
      char[] chars = s.toCharArray();
      StringBuilder sb = new StringBuilder();
      for (char c : chars) {
        if (Character.isDigit(c) && sb.length() > 0) {
          sb.deleteCharAt(sb.length() - 1);
        } else {
          sb.append(c);
        }
      }
      return sb.toString();
    }
  }
}
