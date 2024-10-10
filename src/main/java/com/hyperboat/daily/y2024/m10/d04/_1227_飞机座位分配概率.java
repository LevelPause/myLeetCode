package com.hyperboat.daily.y2024.m10.d04;

/*
 * https://leetcode.cn/problems/airplane-seat-assignment-probability/description/?envType=daily-question&envId=2024-10-04
 * */
public class _1227_飞机座位分配概率 {

  class Solution {

    public double nthPersonGetsNthSeat(int n) {
      return n == 1 ? 1.0 : 0.5;
    }
  }
}
