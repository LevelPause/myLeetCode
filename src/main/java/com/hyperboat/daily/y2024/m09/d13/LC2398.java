package com.hyperboat.daily.y2024.m09.d13;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/*
 * https://leetcode.cn/problems/maximum-number-of-robots-within-budget/
 * */
class LC2398 {

  class Solution {

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
      int n = chargeTimes.length;
      long cost;
      int ans = 0;
      long sum = 0;
      int max;
      int l = 0;
      PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
      for (int r = 0; r < n; r++) {

        pq.offer(chargeTimes[r]);
        max = pq.peek();
        sum += runningCosts[r];
        cost = (long) max + (r - l + 1) * sum;
        if (cost <= budget) {
          ans = Math.max(ans, r - l + 1);
        }
        while (l <= r && cost > budget) {
          pq.remove(chargeTimes[l]);
          max = pq.isEmpty() ? 0 : pq.peek();
          sum -= runningCosts[l];
          l++;
          cost = (long) max + (r - l + 1) * sum;
        }
      }
      return ans;
    }

    private int queue(int[] chargeTimes, int[] runningCosts, long budget) {
      int n = chargeTimes.length;
      long sum = 0;
      int l = 0;
      int ans = 0;
      Deque<Integer> dq = new ArrayDeque<>();
      for (int r = 0; r < n; r++) {
        while (!dq.isEmpty() && chargeTimes[r] >= chargeTimes[dq.peekLast()]) {
          dq.pollLast();
        }
        dq.addLast(r);
        sum += runningCosts[r];
        while (!dq.isEmpty() && chargeTimes[dq.peekFirst()] + sum * (r - l + 1) > budget) {
          if (dq.peekFirst() == l) {
            dq.pollFirst();
          }
          sum -= runningCosts[l++];
        }
        ans = Math.max(ans, r - l + 1);
      }
      return ans;
    }
  }
}
