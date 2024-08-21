package com.hyperboat.daily.y2024.m08.d20;

import java.util.HashMap;
import java.util.Map;

public class _3154_到达第K级台阶的方案数 {

  static class Solution {

    int ans;
    Map<String, Integer> memo;

    public int waysToReachStair(int k) {
      memo = new HashMap<>();
      dfs(false, 0, 1, k);
      return ans;
    }

    public int dfs(boolean back, int jump, int i, int k) {

      if (i > k + 1) {
        return 0;
      }
      String key = "jump" + jump + "i" + i + "back" + (back ? 0 : 1);
      if (memo.containsKey(key)) {
        return memo.get(key);
      }
      int res = k == i ? 1 : 0;
      if (!back && i > 0) {
        res += dfs(true, jump, i - 1, k);
      }
      res += dfs(false, jump + 1, i + (1 << jump), k);
      memo.put(key, res);
      return res;
    }
  }
}
