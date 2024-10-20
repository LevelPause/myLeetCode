package com.hyperboat.题单.hot100.子串;

/**
 * 76. 最小覆盖子串
 * <p>
 * https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked
 */
class LC76 {

  public String minWindow(String s, String t) {
    int n = s.length();
    int[] sArr = new int[60];
    int[] tArr = new int[60];
    int count = 0;
    for (char c : t.toCharArray()) {
      if (tArr[c - 'A']++ == 0) {
        count++;
      }
    }
    int currL = -1;
    int currR = n;
    int l = 0;
    int r = 0;
    String ans = "";
    while (r < n) {
      int rIdx = s.charAt(r) - 'A';
      if (++sArr[rIdx] == tArr[rIdx]) {
        count--;
      }
      while (l < r) {
        int lIdx = s.charAt(l) - 'A';
        if (sArr[lIdx] > tArr[lIdx]) {
          sArr[lIdx] -= 1;
          l++;
        } else {
          break;
        }
      }
      if (count == 0 && currR - currL > r - l) {
        currL = l;
        currR = r;
      }
      r++;
    }
    if (currL == -1) {
      return ans;
    } else {
      return s.substring(currL, currR + 1);
    }
  }
}
