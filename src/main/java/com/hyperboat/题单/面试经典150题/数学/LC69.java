package com.hyperboat.题单.面试经典150题.数学;

/*
 * https://leetcode.cn/problems/sqrtx/?envType=study-plan-v2&envId=top-interview-150
 * */
class LC69 {

  public int mySqrt(int x) {
    int l = 0, r = x;
    int ans = -1;
    while (l <= r) {
      int m = (l + r) / 2;
      if ((long) m * m > x) {
        r = m - 1;
      } else {
        ans = m;
        l = m + 1;
      }
    }
    return ans;
  }
}
