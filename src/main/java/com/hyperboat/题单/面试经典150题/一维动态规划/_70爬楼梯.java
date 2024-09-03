package com.hyperboat.题单.面试经典150题.一维动态规划;

/*
 * https://leetcode.cn/problems/climbing-stairs/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _70爬楼梯 {

  public int climbStairs(int n) {
    int pre = 0;
    int prePre = 0;
    int ans = 1;
    for (int i = 0; i < n; i++) {
      prePre = pre;
      pre = ans;
      ans = prePre + pre;
    }
    return ans;
  }
}
