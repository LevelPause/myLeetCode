package com.hyperboat.题单.位运算.异或性质;

/*
 * https://leetcode.cn/problems/neighboring-bitwise-xor/description/
 * */
public class _2683_相邻值的按位异或 {

  class Solution {

    public boolean doesValidArrayExist(int[] derived) {
      int xor = 0;
      // derived为 0^1, 1^2,...n-2^n-1,n-1^0
      //合法的derved每个元素都异或了两次, 那全部异或起来的结果就是0
      for (int x : derived) {
        xor ^= x;
      }
      return xor == 0;
    }
  }
}
