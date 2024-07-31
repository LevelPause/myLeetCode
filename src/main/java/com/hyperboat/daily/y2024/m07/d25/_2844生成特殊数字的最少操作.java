package com.hyperboat.daily.y2024.m07.d25;

/*
 * https://leetcode.cn/problems/minimum-operations-to-make-a-special-number/description/?envType=daily-question&envId=2024-07-25
 * */
public class _2844生成特殊数字的最少操作 {

  public int minimumOperations(String num) {
    int n = num.length();
    boolean found0 = false;
    boolean found5 = false;
    for (int i = n - 1; i >= 0; i--) {
      char c = num.charAt(i);
      if (found0 && (c == '0' || c == '5')
          || found5 && (c == '7' || c == '2')) {
        return n - i - 2;
      }
      if (c == '0') {
        found0 = true;
      } else if (c == '5') {
        found5 = true;
      }
    }
    return found0 ? n - 1 : n;
  }
}
