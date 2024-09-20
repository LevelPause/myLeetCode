package com.hyperboat.daily.y2024.m09.d20;

import java.util.Arrays;

public class _2376_统计特殊整数 {

  class Solution {

    private char[] arr;
    private int[][] memo;

    public int countSpecialNumbers(int n) {
      arr = Integer.toString(n).toCharArray();
      memo = new int[arr.length][1 << 10];
      for (int[] line : memo) {
        Arrays.fill(line, -1);
      }
      return dfs(0, 0, true, false);
    }

    private int dfs(int i, int mask, boolean isLimit, boolean isNum) {
      if (i == arr.length) {
        return isNum ? 1 : 0;
      }
      if (!isLimit && isNum && memo[i][mask] > 0) {
        return memo[i][mask];
      }
      int res = 0;
      //跳过当前数位
      if (!isNum) {
        res += dfs(i + 1, mask, false, false);
      }
      //枚举当前数位
      int up = isLimit ? arr[i] - '0' : 9;
      for (int j = isNum ? 0 : 1; j <= up; j++) {
        //没有枚举过这个数j
        if ((mask >> j & 1) == 0) {
          res += dfs(i + 1, mask | (1 << j), isLimit && j == up, true);
        }
      }
      if (!isLimit && isNum) {
        memo[i][mask] = res;
      }
      return res;
    }
  }
}
