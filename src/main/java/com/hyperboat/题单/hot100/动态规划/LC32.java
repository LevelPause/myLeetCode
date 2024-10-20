package com.hyperboat.题单.hot100.动态规划;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32. 最长有效括号
 * <p>
 * https://leetcode.cn/problems/longest-valid-parentheses/description/
 */
class LC32 {

  public int longestValidParentheses(String s) {
    return dp(s);
  }

  public int dp(String s) {
    int n = s.length();
    int[] dp = new int[n];
    int maxLen = 0;
    for (int i = 1; i < n; i++) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
        } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
          dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
        }
        maxLen = Math.max(maxLen, dp[i]);
      }
    }
    return maxLen;
  }

  public int stack(String s) {
    int n = s.length();
    Deque<Integer> dq = new ArrayDeque<>();
    dq.push(-1);
    int maxLen = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '(') {
        dq.push(i);
      } else {
        dq.pop();
        if (dq.isEmpty()) {
          dq.push(i);
        }
        maxLen = Math.max(maxLen, i - dq.peek());
      }
    }
    return maxLen;
  }

  public int doublePointer(String s) {
    int n = s.length();
    int maxLen = 0;
    int l = 0, r = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '(') {
        l++;
      } else {
        r++;
      }
      if (l == r) {
        maxLen = Math.max(maxLen, l * 2);
      } else if (r > l) {
        l = r = 0;
      }
    }
    l = r = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (s.charAt(i) == '(') {
        l++;
      } else {
        r++;
      }
      if (l == r) {
        maxLen = Math.max(maxLen, l * 2);
      } else if (l > r) {
        l = r = 0;
      }
    }
    return maxLen;
  }

}
