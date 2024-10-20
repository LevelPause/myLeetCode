package com.hyperboat.daily.y2024.m07.d22;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.cn/problems/detonate-the-maximum-bombs/description/
 * */
class LC2101 {

  // floyd算法, 求解多源最短路径
  public int maximumDetonation(int[][] bombs) {
    int n = bombs.length;
    Set<Integer>[] sets = new HashSet[n];
    for (int i = 0; i < n; i++) {
      long x1 = bombs[i][0];
      long y1 = bombs[i][1];
      long r1 = bombs[i][2];
      sets[i] = new HashSet<>();
      for (int j = 0; j < n; j++) {
        long x2 = bombs[j][0];
        long y2 = bombs[j][1];
        long distance = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
        if (distance <= r1 * r1) {
          sets[i].add(j);
        }
      }
    }
    for (int k = 0; k < n; k++) {
      for (int m = 0; m < n; m++) {
        if (sets[m].contains(k)) {
          sets[m].addAll(sets[k]);
        }
      }
    }
    int ans = 0;
    for (Set<Integer> set : sets) {
      ans = Math.max(ans, set.size());
    }
    return ans;
  }
}
