package com.hyperboat.daily.y2024.m09.d25;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.cn/problems/naming-a-company/
 * */
public class _2306_公司命名 {

  class Solution {

    public long distinctNames(String[] ideas) {
      long ans = 0;
      Set<String>[] groups = new Set[26];
      Arrays.setAll(groups, i -> new HashSet<>());
      for (String idea : ideas) {
        char first = idea.charAt(0);
        groups[first - 'a'].add(idea.substring(1));
      }
      for (int a = 0; a < 25; a++) {
        for (int b = a + 1; b < 26; b++) {
          int size = 0;
          for (String s : groups[a]) {
            if (groups[b].contains(s)) {
              size++;
            }
          }
          ans += (long) (groups[a].size() - size) * (groups[b].size() - size);
        }
      }
      return ans * 2;
    }
  }
}
