package com.hyperboat.题单.面试经典150题.区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.cn/problems/merge-intervals/?envType=study-plan-v2&envId=top-interview-150
 * */
class LC56 {

  public int[][] merge(int[][] intervals) {
    return normal(intervals);
  }

  //拙劣的并查集, 强行使用并查集, 在union的时候就已经O(n²)了, 得不偿失
  public int[][] uf(int[][] intervals) {
    int n = intervals.length;
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
    UnionFind uf = new UnionFind(n);
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        if (intervals[i][1] >= intervals[j][0] && intervals[i][0] <= intervals[j][1]) {
          uf.union(i, j);
        }
      }
    }
    for (int i = 0; i < n; i++) {
      uf.find(i);
    }
    Map<Integer, int[]> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int root = uf.find(i);
      int[] orDefault = map.getOrDefault(root, intervals[i]);
      map.put(root, new int[]{Math.min(intervals[i][0], orDefault[0]),
          Math.max(intervals[i][1], orDefault[1])});
    }
    return map.values().toArray(new int[0][0]);

  }

  /*
   * 朴素的排序后遍历，瓶颈在排序
   * */
  public int[][] normal(int[][] intervals) {
    int n = intervals.length;
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
    List<int[]> ans = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int size = ans.size();
      if (i > 0 && ans.get(size - 1)[1] >= intervals[i][0]) {
        ans.get(size - 1)[1] = Math.max(ans.get(size - 1)[1], intervals[i][1]);
      } else {
        ans.add(intervals[i]);
      }
    }
    return ans.toArray(new int[0][0]);
  }

  class UnionFind {

    int[] parents;

    public UnionFind(int n) {
      this.parents = new int[n];
      for (int i = 0; i < parents.length; i++) {
        parents[i] = i;
      }
    }

    public int find(int index) {
      if (parents[index] != index) {
        parents[index] = find(parents[index]);
      }
      return parents[index];
    }

    public void union(int i1, int i2) {
      parents[find(i1)] = find(i2);
    }
  }
}
