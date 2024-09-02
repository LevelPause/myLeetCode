package com.hyperboat.竞赛.双周赛138;

public class _Q1_求出数字答案 {

  class Solution {

    public int generateKey(int num1, int num2, int num3) {
      int ans = 0;
      for (int i = 0; i < 4; i++) {
        int temp = Math.min(Math.min(num1 % 10, num2 % 10), num3 % 10);
        ans += temp * Math.pow(10, i);
        num1 /= 10;
        num2 /= 10;
        num3 /= 10;
      }
      return ans;
    }
  }
}
