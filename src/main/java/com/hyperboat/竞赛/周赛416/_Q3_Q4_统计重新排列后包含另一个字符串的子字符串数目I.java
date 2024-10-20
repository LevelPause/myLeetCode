package com.hyperboat.竞赛.周赛416;

/*
 * https://leetcode.cn/contest/weekly-contest-416/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-i/
 * https://leetcode.cn/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-ii/description/
 * */
class _Q3_Q4_统计重新排列后包含另一个字符串的子字符串数目I {

  static class Solution {

    public long validSubstringCount(String word1, String word2) {
      int m = word1.length();
      int n = word2.length();
      if (m < n) {
        return 0;
      }
      int[] pattern = new int[26];
      for (char c : word2.toCharArray()) {
        pattern[c - 'a']++;
      }
      int cnt = 0;
      for (int i : pattern) {
        if (i > 0) {
          cnt++;
        }
      }
      long ans = 0L;
      int l = 0;
      int r = 0;
      while (r < m) {
        int i = word1.charAt(r) - 'a';
        if (--pattern[i] == 0) {
          cnt--;
        }
        while (cnt == 0) {
          int j = word1.charAt(l++) - 'a';
          if (pattern[j]++ == 0) {
            cnt++;
          }
        }
        ans += l;
        r++;
      }
      return ans;
    }

  }
}
