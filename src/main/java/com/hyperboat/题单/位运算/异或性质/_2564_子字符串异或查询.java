package com.hyperboat.题单.位运算.异或性质;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.cn/problems/substring-xor-queries/description/
 * */
public class _2564_子字符串异或查询 {

  class Solution {

    public int[][] substringXorQueries(String s, int[][] queries) {
      Map<Integer, int[]> map = new HashMap<>();
      int n = s.length();
      int index = s.indexOf("0");
      if (index >= 0) {
        map.put(0, new int[]{index, index});
      }
      char[] chars = s.toCharArray();
      for (int i = 0; i < n; i++) {
        char c = chars[i];
        if (c == '0') {
          continue;
        }
        for (int j = i, x = 0; j < Math.min(i + 30, n); j++) {
          x = (x << 1) | (chars[j] & 1);
          map.putIfAbsent(x, new int[]{i, j});
        }
      }
      int m = queries.length;
      int[][] ans = new int[m][2];
      for (int i = 0; i < m; i++) {
        int l = queries[i][0];
        int r = queries[i][1];
        ans[i] = map.getOrDefault(l ^ r, new int[]{-1, -1});
      }
      return ans;
    }
  }
}
