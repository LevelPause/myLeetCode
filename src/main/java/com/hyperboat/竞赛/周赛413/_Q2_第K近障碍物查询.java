package com.hyperboat.竞赛.周赛413;

import java.util.PriorityQueue;

/*
 * https://leetcode.cn/contest/weekly-contest-413/problems/k-th-nearest-obstacle-queries/
 * */
class _Q2_第K近障碍物查询 {

  class Solution {

    public int[] resultsArray(int[][] queries, int k) {
      PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
      int n = queries.length;
      int[] ans = new int[n];
      for (int i = 0; i < queries.length; i++) {
        int[] query = queries[i];
        int dis = Math.abs(query[0]) + Math.abs(query[1]);
        if (pq.size() < k) {
          pq.offer(dis);
          ans[i] = pq.size() == k ? pq.peek() : -1;
        } else {
          if (dis < pq.peek()) {
            pq.poll();
            pq.offer(dis);
          }
          ans[i] = pq.peek();
        }
      }
      return ans;
    }
  }
}
