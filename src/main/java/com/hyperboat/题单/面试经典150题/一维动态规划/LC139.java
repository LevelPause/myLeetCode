package com.hyperboat.题单.面试经典150题.一维动态规划;

import java.util.List;

/*
 * https://leetcode.cn/problems/word-break/description/?envType=study-plan-v2&envId=top-interview-150
 * */
class LC139 {

  public boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < i; j++) {
        String word = s.substring(j, i);
        if (wordDict.contains(word) && dp[j]) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[n];
  }

}
