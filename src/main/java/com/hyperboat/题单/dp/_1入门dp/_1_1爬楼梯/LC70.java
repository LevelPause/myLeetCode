package com.hyperboat.题单.dp._1入门dp._1_1爬楼梯;

/**
 * 70. 爬楼梯
 * <p>
 * https://leetcode.cn/problems/climbing-stairs/description/
 */
class LC70 {

  public int climbStairs(int n) {
    int dp1 = 1;
    int dp2 = 1;
    for (int i = 0; i < n; i++) {
      int t = dp2;
      dp2 = dp2 + dp1;
      dp1 = t;
    }
    return dp2;
  }

}
