package com.hyperboat.竞赛.双周赛140;

/*
 * https://leetcode.cn/contest/biweekly-contest-140/problems/find-the-lexicographically-smallest-valid-sequence/description/
 * */
public class _Q3_字典序最小的合法序列 {

  class Solution {

    public int[] validSequence(String word1, String word2) {
      int m = word1.length();
      int n = word2.length();
      int[] ans = new int[n];
      //构造后缀数组, suf[i]表示word1在i位置上的对于word2的最长后缀
      int[] suf = new int[m + 1];
      suf[m] = n;
      int j = n - 1;
      for (int i = m - 1; i >= 0; i--) {
        if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
          j--;
        }
        suf[i] = j + 1;
      }

      int l = 0;
      boolean changed = false;
      for (int r = 0; r < m; r++) {
        char a = word1.charAt(r);
        char b = word2.charAt(l);
        if (a == b || !changed && suf[r + 1] <= l + 1) {
          if (a != b) {
            changed = true;
          }
          ans[l++] = r;
          if (l == n) {
            return ans;
          }
        }
      }
      return new int[0];
    }
  }
}
