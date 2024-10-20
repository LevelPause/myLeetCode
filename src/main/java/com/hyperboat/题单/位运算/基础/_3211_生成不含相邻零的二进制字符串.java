package com.hyperboat.题单.位运算.基础;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.cn/problems/generate-binary-strings-without-adjacent-zeros/description/
 * */
class _3211_生成不含相邻零的二进制字符串 {

  class Solution {

    private List<String> ans;

    public List<String> validStrings(int n) {
      ans = new ArrayList<>();

      dfs(0, n, new StringBuilder(n));
      return ans;
    }

    private void dfs(int i, int n, StringBuilder sb) {
      if (i == n) {
        ans.add(sb.toString());
        return;
      }
      sb.append("1");
      dfs(i + 1, n, sb);
      sb.deleteCharAt(sb.length() - 1);
      if (sb.length() == 0 || sb.charAt(sb.length() - 1) == '1') {
        sb.append("0");
        dfs(i + 1, n, sb);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}
