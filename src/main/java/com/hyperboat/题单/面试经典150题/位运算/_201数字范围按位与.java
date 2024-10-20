package com.hyperboat.题单.面试经典150题.位运算;

/*
 * https://leetcode.cn/problems/bitwise-and-of-numbers-range/?envType=study-plan-v2&envId=top-interview-150
 *
 * */
class _201数字范围按位与 {

  public int rangeBitwiseAnd(int left, int right) {
    return normal(left, right);
  }

  public int normal(int l, int r) {
    int shift = 0;
    while (l < r) {
      l >>= 1;
      r >>= 1;
      shift++;
    }
    return r << shift;
  }

  //  Brian Kernighan 算法 用于清除二进制串最右边的1;
  public int brianKernighan(int l, int r) {
    while (l < r) {
      r &= r - 1;
    }
    return r;
  }
}
