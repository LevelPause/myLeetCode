package com.hyperboat.竞赛.双周赛139;

import java.util.ArrayList;
import java.util.List;

/*
 *https://leetcode.cn/problems/length-of-the-longest-increasing-path/
 * */
public class Q4 {

  class Solution {

    public int maxPathLength(int[][] coordinates, int k) {
      int a = coordinates[k][0];
      int b = coordinates[k][1];
      List<int[]> arr = new ArrayList<>();
      for (int[] sub : coordinates) {
        if (sub[0] > a && sub[1] < b) {
          continue;
        }
        if (sub[0] < a && sub[1] > b) {
          continue;
        }
        arr.add(new int[]{sub[0], sub[1]});
      }
      arr.add(new int[]{a, b});
      arr.sort((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);
      int n = arr.size();
      List<Integer> ansList = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int tail = ansList.size() - 1;
        int y = arr.get(i)[1];
        if (ansList.isEmpty() || ansList.get(tail) > y) {
          ansList.add(y);
        } else {
          int l = 0, r = tail;
          while (l <= r) {
            int m = (l + r) >> 1;
            if (y <= ansList.get(m)) {
              r = m - 1;
            } else {
              l = m + 1;
            }
          }
          ansList.set(l, y);
        }
      }
      return ansList.size();
    }
  }
}
