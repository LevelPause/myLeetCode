package com.hyperboat.题单.面试经典150题.位运算;

/*
 * https://leetcode.cn/problems/single-number/?envType=study-plan-v2&envId=top-interview-150
 * */
class LC136 {

  public int singleNumber(int[] nums) {
    int ans = 0;
    for (int num : nums) {
      ans ^= num;
    }
    return ans;
  }
}
