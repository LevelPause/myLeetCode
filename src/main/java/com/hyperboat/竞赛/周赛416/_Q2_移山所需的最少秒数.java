package com.hyperboat.竞赛.周赛416;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * https://leetcode.cn/contest/weekly-contest-416/problems/minimum-number-of-seconds-to-make-mountain-height-zero/
 * */
public class _Q2_移山所需的最少秒数 {

  static class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
      PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
      for (int workerTime : workerTimes) {
        pq.offer(new long[]{workerTime, workerTime, 1});
      }
      long maxTime = 0;
      while (mountainHeight > 0) {
        long[] poll = pq.poll();
        poll[2] += 1;
        poll[0] += poll[1] * poll[2];
        maxTime = Math.max(poll[0], maxTime);
        pq.offer(poll);
        mountainHeight--;
      }
      return maxTime;
    }
  }
}
