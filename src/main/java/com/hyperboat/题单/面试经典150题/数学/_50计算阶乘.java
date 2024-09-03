package com.hyperboat.题单.面试经典150题.数学;

/*
 * https://leetcode.cn/problems/powx-n/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _50计算阶乘 {

  /*
   * 快速幂,运用aᵇ*aᵈ=aᵇ⁺ᵈ的性质和位运算
   * x⁵= x⁴*x
   * x⁷=x⁴*x²*x
   *
   * */
  public double myPow(double x, int n) {
    long d = n;
    if (d < 0) {
      d = -d;
      x = 1 / x;
    }
    double ans = 1.0d;
    while (d > 0) {
      if ((d & 1) == 1) {
        ans *= x;
      }
      x *= x;
      d >>= 1;
    }
    return ans;
  }

}
