package com.hyperboat.daily.y2024.m08.d24;

public class LC3146 {

  class Solution {

    public int findPermutationDifference(String s, String t) {
      int n = s.length();
      int ans = 0;
      int[] index = new int[26];
      for (int i = 0; i < n; i++) {
        char sc = s.charAt(i);
        index[sc - 'a'] = i;
      }
      for (int i = 0; i < n; i++) {
        int tc = t.charAt(i);
        ans += Math.abs(index[tc - 'a'] - i);
      }
      return ans;
    }
  }
}
