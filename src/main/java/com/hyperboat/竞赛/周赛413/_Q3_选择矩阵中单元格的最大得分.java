package com.hyperboat.竞赛.周赛413;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _Q3_选择矩阵中单元格的最大得分 {

  class Solution {

    private int[][] memo;
    private List<Integer> nums;
    private Map<Integer, Integer> map;

    public int maxScore(List<List<Integer>> grid) {
      int m = grid.size();
      map = new HashMap<>();

      for (int i = 0; i < m; i++) {
        List<Integer> row = grid.get(i);
        for (Integer num : row) {
          map.merge(num, 1 << i, (a, b) -> a | b);
        }
      }

      nums = new ArrayList<>(map.keySet());
      int size = nums.size();
      memo = new int[size][1 << m];
      for (int[] row : memo) {
        Arrays.fill(row, -1);
      }
      return dfs(size - 1, 0);
    }

    private int dfs(int i, int j) {
      if (i < 0) {
        return 0;
      }
      if (memo[i][j] != -1) {
        return memo[i][j];
      }
      int ans = dfs(i - 1, j);
      int num = nums.get(i);
      for (int t = map.get(num), mask; t > 0; t ^= mask) {//t ^= mask  ==>  t中去掉mask
        mask = t & -t; // t&-t ==>  t的从低到高的第一个1, 比如  1010&-1010 == 1010&0111 == 0010
        if ((j & mask) == 0) {
          ans = Math.max(ans, dfs(i - 1, j | mask) + num);
        }
      }
      return memo[i][j] = ans;
    }
  }
}
