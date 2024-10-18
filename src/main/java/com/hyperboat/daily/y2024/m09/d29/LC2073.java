package com.hyperboat.daily.y2024.m09.d29;

/*
 *
 * https://leetcode.cn/problems/time-needed-to-buy-tickets/description/?envType=daily-question&envId=2024-09-29
 * */
public class LC2073 {

  class Solution {

    public int timeRequiredToBuy(int[] tickets, int k) {
      int ans = 0;
      int max = tickets[k];
      for (int i = 0; i < tickets.length; i++) {
        if (i <= k) {
          ans += Math.min(max, tickets[i]);
        } else {
          ans += Math.min(max - 1, tickets[i]);
        }
      }
      return ans;
    }
  }
}
