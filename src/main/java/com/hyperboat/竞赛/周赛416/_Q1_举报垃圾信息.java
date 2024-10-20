package com.hyperboat.竞赛.周赛416;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.cn/contest/weekly-contest-416/problems/report-spam-message/
 * */
class _Q1_举报垃圾信息 {

  class Solution {

    public boolean reportSpam(String[] message, String[] bannedWords) {
      Set<String> set = new HashSet<>(Arrays.asList(bannedWords));
      int cnt = 0;
      for (String s : message) {
        if (set.contains(s)) {
          cnt++;
        }
        if (cnt >= 2) {
          return true;
        }
      }
      return false;
    }
  }
}
