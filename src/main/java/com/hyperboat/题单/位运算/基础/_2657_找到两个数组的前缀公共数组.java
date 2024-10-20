package com.hyperboat.题单.位运算.基础;

/*
 * https://leetcode.cn/problems/find-the-prefix-common-array-of-two-arrays/description/
 * */
class _2657_找到两个数组的前缀公共数组 {

  class Solution {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
      int n = A.length;
      long maskA = 0L;
      long maskB = 0L;
      int[] ans = new int[n];
      for (int i = 0; i < n; i++) {
        maskA |= 1L << A[i];
        maskB |= 1L << B[i];
        ans[i] = Long.bitCount(maskA & maskB);
      }
      return ans;
    }
  }
}
