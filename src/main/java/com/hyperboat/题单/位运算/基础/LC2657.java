package com.hyperboat.题单.位运算.基础;

/**
 * 2657. 找到两个数组的前缀公共数组
 * <p>
 * https://leetcode.cn/problems/find-the-prefix-common-array-of-two-arrays/description/
 */
class LC2657 {

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
