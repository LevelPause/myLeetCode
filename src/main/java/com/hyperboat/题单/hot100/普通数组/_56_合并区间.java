package com.hyperboat.题单.hot100.普通数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56_合并区间 {

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
    int i = 0;
    int n = intervals.length;
    List<int[]> res = new ArrayList<>();
    while (i < n) {
      int[] curr = intervals[i];
      while (++i < n) {
        int[] next = intervals[i];
        if (next[0] > curr[1]) {
          break;
        } else {
          curr[1] = Math.max(curr[1], next[1]);
        }
      }
      res.add(curr);
    }
    return res.toArray(new int[0][0]);
  }
}
