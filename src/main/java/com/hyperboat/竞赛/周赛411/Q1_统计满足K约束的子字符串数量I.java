package com.hyperboat.竞赛.周赛411;

class Q1_统计满足K约束的子字符串数量I {

  class Solution {

    public int countKConstraintSubstrings(String s, int k) {
      int n = s.length();
      int ans = 0;
      for (int i = 0; i < n; i++) {
        int zeros = 0;
        int ones = 0;
        for (int j = i; j < n; j++) {
          if (s.charAt(j) == '0') {
            zeros++;
          } else {
            ones++;
          }
          if (ones >= k || zeros >= k) {
            ans++;
          }
        }
      }
      return ans;
    }
  }
}
