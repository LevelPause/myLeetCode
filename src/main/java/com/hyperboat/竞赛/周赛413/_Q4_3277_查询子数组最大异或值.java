package com.hyperboat.竞赛.周赛413;

public class _Q4_3277_查询子数组最大异或值 {

  class Solution {

    public int[] maximumSubarrayXor(int[] nums, int[][] queries) {
      int n = nums.length;
      // dp[i][j] 区间i-j 的异或值
      int[][] dp = new int[n][n];
      // max[i][j] 区间i-j 内所有子数组的最大异或值
      int[][] max = new int[n][n];
        /*
        a,b,c         a,b,c,d
        a^b b^c       a^b b^c c^d
        a^b^b^c       a^b^b^c   b^c^c^d
        dp[0,2]       dp[0,2]  dp[1,3]
        可见: dp[0,3] =dp[0,2] ^ dp[1,3]
        因此递推式: dp[i][j]=dp[i][j-1] ^ dp[i+1][j]

        对于询问: i-j之间最大值max[i][j]=max(dp[i][j],max[i+1][j],max[i][j-1])
        */
      for (int i = n - 1; i >= 0; i--) {
        dp[i][i] = nums[i];
        max[i][i] = nums[i];
        for (int j = i + 1; j < n; j++) {
          dp[i][j] = dp[i][j - 1] ^ dp[i + 1][j];
          max[i][j] = Math.max(dp[i][j], Math.max(max[i][j - 1], max[i + 1][j]));
        }
      }
      int len = queries.length;
      int[] ans = new int[len];
      for (int i = 0; i < len; i++) {
        int[] query = queries[i];
        ans[i] = max[query[0]][query[1]];
      }
      return ans;
    }
  }
}
