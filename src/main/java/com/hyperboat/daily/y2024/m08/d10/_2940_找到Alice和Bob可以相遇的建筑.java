package com.hyperboat.daily.y2024.m08.d10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * https://leetcode.cn/problems/find-building-where-alice-and-bob-can-meet/
 * */
public class _2940_找到Alice和Bob可以相遇的建筑 {

  public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
    int n = queries.length;
    int length = heights.length;
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    List<int[]>[] qs = new ArrayList[length];
    Arrays.setAll(qs, i -> new ArrayList<>());
    for (int i = 0; i < n; i++) {
      int[] query = queries[i];
      int a = query[0];
      int b = query[1];
      if (a > b) {
        a ^= b;
        b ^= a;
        a ^= b;
      }
      if (a == b || heights[a] < heights[b]) {
        ans[i] = b;
      } else {
        qs[b].add(new int[]{heights[a], i});
      }
    }
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    for (int i = 0; i < length; i++) {
      while (!pq.isEmpty() && pq.peek()[0] < heights[i]) {
        ans[pq.poll()[1]] = i;
      }
      for (int[] q : qs[i]) {
        pq.offer(q);
      }
    }
    return ans;
  }
}
