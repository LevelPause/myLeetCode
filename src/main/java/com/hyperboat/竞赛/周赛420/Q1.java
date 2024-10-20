package com.hyperboat.竞赛.周赛420;

import java.util.ArrayList;
import java.util.List;

/**
 * Q1. 出现在屏幕上的字符串序列
 * <p>
 * https://leetcode.cn/contest/weekly-contest-420/problems/find-the-sequence-of-strings-appeared-on-the-screen/description/
 */
class Q1 {

  public List<String> stringSequence(String target) {
    var ans = new ArrayList<String>();
    for (char c : target.toCharArray()) {
      var last = ans.isEmpty() ? "" : ans.get(ans.size() - 1);
      var cnt = c - 'a';
      for (int i = 0; i <= cnt; i++) {
        ans.add(last + (char) ('a' + i));
      }
    }
    return ans;
  }
}
