package com.hyperboat.normal.diffcult;

import java.util.Arrays;

class LC1012 {

  class Solution {

    private char[] arr;
    private int[][] memo;

    public int numDupDigitsAtMostN(int n) {
      arr = Integer.toString(n).toCharArray();
      memo = new int[arr.length][1 << 10];
      for (int[] line : memo) {
        Arrays.fill(line, -1);
      }
      return n - dfs(0, 0, false, true);
    }

    private int dfs(int i, int mask, boolean isNum, boolean limit) {
      if (i == arr.length) {
        return isNum ? 1 : 0;
      }
      if (!limit && isNum && memo[i][mask] != -1) {
        return memo[i][mask];
      }
      int res = 0;
      if (!isNum) {
        res += dfs(i + 1, mask, false, false);
      }
      int up = limit ? arr[i] - '0' : 9;
      for (int x = isNum ? 0 : 1; x <= up; x++) {
        if ((mask >> x & 1) == 0) {
          res += dfs(i + 1, mask | (1 << x), true, limit && x == up);
        }
      }
      if (!limit && isNum) {
        memo[i][mask] = res;
      }
      return res;
    }
  }
}
