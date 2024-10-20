package com.hyperboat.题单.面试经典150题.双指针;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class _392判断子序列 {

  public boolean isSubsequence(String s, String t) {
    int n = s.length();
    int m = t.length();
    if (n < 1) {
      return true;
    }
    if (m < 1) {
      return false;
    }
    int i = 0;
    int j = 0;
    int index = 0;
    while (i < m) {
      while (j < n) {
        if (i < m && s.charAt(j) == t.charAt(i)) {
          index = i++;
          if (j == n - 1) {
            return true;
          }
          j++;
        } else {
          i = Math.max(index, i);
          i++;
          break;
        }
      }
    }
    return false;
  }
}
