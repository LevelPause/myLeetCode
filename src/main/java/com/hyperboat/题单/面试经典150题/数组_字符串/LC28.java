package com.hyperboat.题单.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC28 {

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
