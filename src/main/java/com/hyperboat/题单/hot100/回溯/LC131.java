package com.hyperboat.题单.hot100.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * <p>
 * https://leetcode.cn/problems/palindrome-partitioning/description/
 */
class LC131 {

  private int n;
  private String s;
  private boolean[][] dp;
  private List<List<String>> res;

  public List<List<String>> partition(String s) {
    n = s.length();
    this.s = s;
    dp = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      explore(i, i);
      explore(i, i + 1);
    }
    res = new ArrayList<>();
    backTrace(0, 0, new ArrayList<>());
    return res;
  }

  private void explore(int l, int r) {
    while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
      dp[l][r] = true;
      l--;
      r++;
    }
  }

  private void backTrace(int start, int index, List<String> line) {
    if (index == n) {
      res.add(new ArrayList<>(line));
      return;
    }
    if (index < n - 1) {
      backTrace(start, index + 1, line);
    }
    if (dp[start][index]) {
      line.add(s.substring(start, index + 1));
      backTrace(index + 1, index + 1, line);
      line.remove(line.size() - 1);
    }
  }

}
