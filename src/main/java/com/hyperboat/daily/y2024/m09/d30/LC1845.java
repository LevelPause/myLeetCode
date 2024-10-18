package com.hyperboat.daily.y2024.m09.d30;

import java.util.PriorityQueue;

/*
 * https://leetcode.cn/problems/seat-reservation-manager/description/
 * */
public class LC1845 {

  class SeatManager {

    //pq用来存放被unreserve退回的座位
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    //min表示在这个数之前的座位都是被预定过的
    private int min = 1;

    public SeatManager(int n) {
    }

    public int reserve() {
      //首先明确一点: unreserve方法退回的座位一定是比min小的, 所以优先返回队列中的座位
      if (!pq.isEmpty()) {
        return pq.poll();
      }
      return min++;
    }

    public void unreserve(int seatNumber) {
      //实际业务中这里应该写一个非法校验, 用于fast-fail
     /* if (seatNumber >= min) {
        return;
      }*/
      pq.offer(seatNumber);
    }
  }

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
}
