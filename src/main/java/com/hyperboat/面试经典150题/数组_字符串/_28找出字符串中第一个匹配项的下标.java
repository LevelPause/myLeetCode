package com.hyperboat.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
public class _28找出字符串中第一个匹配项的下标 {

  public int strStr(String haystack, String needle) {
    int m = haystack.length();
    int n = needle.length();
    if (m < n) {
      return -1;
    }
    int res;
    int i = 0;
    while (i < m) {
      res = i;
      int temp = i;
      for (int j = 0; j < n; j++) {
        if (temp < m && haystack.charAt(temp) == needle.charAt(j)) {
          if (j == n - 1) {
            return res;
          }
          temp++;
        } else {
          break;
        }
      }
      i++;
    }
    return -1;
  }
}
