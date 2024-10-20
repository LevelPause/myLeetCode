package com.hyperboat.daily.y2024.m10.d07;

import java.util.PriorityQueue;

/*
 * https://leetcode.cn/problems/minimum-number-of-refueling-stops/description/
 * */
class LC871 {

  class Solution {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
      if (startFuel >= target) {
        return 0;
      }
      int n = stations.length;
      PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
      int fuel = startFuel, ans = 0, pre = 0;
      for (int i = 0; i <= n; i++) {
        // 当前所到加油站位置, i==n时代表没有加油站了, 下一站只能直接开到终点
        int curr = i < n ? stations[i][0] : target;
        // 扣除到达当前站所用汽油
        fuel -= curr - pre;
        // 汽油小于0, 表示油不够, 则从之前走过的加油站加油, 从大到小加
        while (fuel < 0 && !pq.isEmpty()) {
          fuel += pq.poll();
          ans++;
        }
        // 加过油还是不够, 说明走不到当前站点
        if (fuel < 0) {
          return -1;
        }
        // 走到的站点是加油站时, 将油放入队列以供以后加油, 并更新最新到达的位置
        if (i < n) {
          pq.offer(stations[i][1]);
          pre = curr;
        }
      }
      return ans;
    }
  }
}
