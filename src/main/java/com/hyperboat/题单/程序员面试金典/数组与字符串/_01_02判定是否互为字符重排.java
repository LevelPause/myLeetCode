package com.hyperboat.题单.程序员面试金典.数组与字符串;

public class _01_02判定是否互为字符重排 {

  public boolean CheckPermutation(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    if (m != n) {
      return false;
    }
    int[] b = new int[26];
    for (int i = 0; i < m; i++) {
      b[s1.charAt(i) - 'a']++;
      b[s2.charAt(i) - 'a']--;
    }
    for (int i : b) {
      if (i != 0) {
        return false;
      }
    }
    return true;
  }
}
