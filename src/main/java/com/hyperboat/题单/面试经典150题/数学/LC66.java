package com.hyperboat.题单.面试经典150题.数学;

/*
 * https://leetcode.cn/problems/plus-one/description/?envType=study-plan-v2&envId=top-interview-150
 * */
class LC66 {

  public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i] = (digits[i] + 1) % 10;
      if (digits[i] != 0) {
        return digits;
      }
    }
    int[] res = new int[digits.length + 1];
    res[0] = 1;
    return res;
  }
}
