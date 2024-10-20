package com.hyperboat.daily.y2024.m08.d14;

class LC3152 {

  public boolean[] isArraySpecial(int[] nums, int[][] queries) {
    int n = nums.length;
    int length = queries.length;
    int[] sum = new int[n];
    boolean[] ans = new boolean[length];
    for (int i = 1; i < n; i++) {
      sum[i] = sum[i] + nums[i] % 2 == nums[i - 1] % 2 ? 1 : 0;
    }
    for (int i = 0; i < queries.length; i++) {
      ans[i] = sum[queries[i][0]] == sum[queries[i][1]];
    }
    return ans;
  }
}
