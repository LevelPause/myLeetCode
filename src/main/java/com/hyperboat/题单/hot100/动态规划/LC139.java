package com.hyperboat.题单.hot100.动态规划;

import java.util.List;

/**
 * 139. 单词拆分
 * <p>
 * https://leetcode.cn/problems/word-break/description/
 */
class LC139 {

  public boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (int i = 0; i < n + 1; i++) {
      for (int j = i; j >= 0; j--) {
        dp[i] = dp[i] | (dp[j] && wordDict.contains(s.substring(j, i)));
        if (dp[i]) {
          break;
        }
      }
    }
    return dp[n];
  }

}
