package com.hyperboat.竞赛.双周赛140;

/*
 * https://leetcode.cn/problems/find-the-occurrence-of-first-almost-equal-substring/description/
 * */
public class _Q4_第一个几乎相等子字符串的下标 {

  //前后缀数组, Z函数, 好难
  class Solution {

    public int minStartingIndex(String s, String pattern) {
      int[] preZ = calcZ(pattern + s);
      int[] sufZ = calcZ(rev(pattern) + rev(s));
      // 可以不反转 sufZ，下面写 sufZ[sufZ.length - i]
      int n = s.length();
      int m = pattern.length();
      for (int i = m; i <= n; i++) {
        if (preZ[i] + sufZ[sufZ.length - i] >= m - 1) {
          return i - m;
        }
      }
      return -1;
    }

    private int[] calcZ(String S) {
      char[] s = S.toCharArray();
      int n = s.length;
      int[] z = new int[n];
      int boxL = 0;
      int boxR = 0; // z-box 左右边界
      for (int i = 1; i < n; i++) {
        if (i <= boxR) {
          z[i] = Math.min(z[i - boxL], boxR - i + 1);
        }
        while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
          boxL = i;
          boxR = i + z[i];
          z[i]++;
        }
      }
      return z;
    }

    private String rev(String s) {
      return new StringBuilder(s).reverse().toString();
    }
  }
}
