package com.hyperboat.题单.面试经典150题.区间;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.cn/problems/insert-interval/description/?envType=study-plan-v2&envId=top-interview-150
 * */
class LC57 {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> ans = new ArrayList<>();
    int n = intervals.length;
    int i = 0;
//    新区间左边的区间们
    while (i < n && intervals[i][1] < newInterval[0]) {
      ans.add(intervals[i++]);
    }
//    重叠的区间们，
    while (i < n && intervals[i][0] <= newInterval[1]) {
      newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
      newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
      i++;
    }
//    如果上一个while没进去，说明是完全不重叠，这里的newInterval直接插入也没问题(弄明白这个思路非常重要)
    ans.add(newInterval);
//    右边的区间们
    while (i < n) {
      ans.add(intervals[i++]);
    }
    return ans.toArray(new int[0][0]);
  }
}
