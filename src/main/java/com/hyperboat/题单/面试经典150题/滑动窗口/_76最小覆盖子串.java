package com.hyperboat.题单.面试经典150题.滑动窗口;

// hard
// https://leetcode.cn/problems/minimum-window-substring/?envType=study-plan-v2&envId=top-interview-150
// 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
class _76最小覆盖子串 {

  public String minWindow(String s, String t) {
    int length = s.length();
    int[] a = new int[60];
    int[] b = new int[60];
    int count = 0;
    String ans = "";
    for (char c : t.toCharArray()) {
      if (a[c - 'A']++ == 0) {
        count++;
      }
    }
    int finalL = -1;
    int finalR = length;
    int l = 0;
    int r = 0;
    for (; r < length; r++) {
      char rChar = s.charAt(r);
      if (++b[rChar - 'A'] == a[rChar - 'A']) {
        count--;
      }
      while (l < r) {
        char _har = s.charAt(l);
        if (b[_har - 'A'] > a[_har - 'A'] && --b[_har - 'A'] >= 0) {
          l++;
        } else {
          break;
        }
      }
      if (count == 0) {
        if (finalR - finalL > r - l) {
          finalR = r;
          finalL = l;
        }
      }
    }
    if (finalL != -1) {
      ans = s.substring(finalL, finalR + 1);
    }
    return ans;
  }
}
