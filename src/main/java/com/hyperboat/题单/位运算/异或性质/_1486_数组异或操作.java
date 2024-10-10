package com.hyperboat.题单.位运算.异或性质;

/*
 * https://leetcode.cn/problems/xor-operation-in-an-array/description/
 * */
public class _1486_数组异或操作 {

  class Solution {

    public int xorOperation(int n, int start) {
      int ans = start;
      for (int i = 1; i < n; i++) {
        ans ^= start + i * 2;
      }
      return ans;
    }
  }
}
