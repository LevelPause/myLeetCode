package com.hyperboat.题单.位运算.异或性质;

/**
 * 1310. 子数组异或查询
 * <p>
 * https://leetcode.cn/problems/xor-queries-of-a-subarray/description/
 */
class LC1310 {

  public int[] xorQueries(int[] arr, int[][] queries) {
    int n = arr.length;
    int m = queries.length;
    int[] xor = new int[n];
    xor[0] = arr[0];
    for (int i = 1; i < n; i++) {
      xor[i] = xor[i - 1] ^ arr[i];
    }

    int[] ans = new int[m];
    for (int i = 0; i < m; i++) {
      int l = queries[i][0];
      int r = queries[i][1];
      ans[i] = arr[l] ^ xor[l] ^ xor[r];
    }
    return ans;
  }

}
