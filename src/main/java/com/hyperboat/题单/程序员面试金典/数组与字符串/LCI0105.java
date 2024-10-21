package com.hyperboat.题单.程序员面试金典.数组与字符串;

/**
 * 面试题 01.05.一次编辑
 * <p>
 * https://leetcode.cn/problems/one-away-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
class LCI0105 {

  public boolean oneEditAway(String first, String second) {
    int m = first.length();
    int n = second.length();
    if (Math.abs(m - n) > 1) {
      return false;
    }
    if (m > n) {
      return oneEditAway(second, first);
    }
    int l = 0, r = 0, cnt = 0;
    while (l < m && r < n && cnt <= 1) {
      char c1 = first.charAt(l);
      char c2 = second.charAt(r);
      if (c1 == c2) {
        l++;
        r++;
      } else {
        if (n == m) {
          l++;
          r++;
          cnt++;
        } else {
          r++;
          cnt++;
        }
      }
    }
    return cnt <= 1;
  }
}
