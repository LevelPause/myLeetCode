package com.hyperboat.题单.面试经典150题.位运算;

/*
 * https://leetcode.cn/problems/single-number-ii/description/?envType=study-plan-v2&envId=top-interview-150
 * */
class LC137 {

  public int singleNumber(int[] nums) {
    int ans = 0;
    for (int i = 0; i < 32; i++) {
      int num = 0;
      for (int n : nums) {
        num += n >> i & 1;
      }
      ans |= num % 3 << i;
    }
    return ans;
  }

  //模仿模三的加法
  public int byBit(int[] nums) {
    int a = 0;
    int b = 0;
    for (int x : nums) {
      b = (b ^ x) & ~a;
      a = (a ^ x) & ~b;
    }
    return b;
  }
}
