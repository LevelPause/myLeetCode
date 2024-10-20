package com.hyperboat.normal.medium;

/**
 * @author zhangweigang
 * @date 2023年10月18日 4:39
 *
 * dp[i][j]=x表示以(i,j)为右下角的正方形的最大边长，也表示以(i,j)为右下角的正方形的个数(这个太难想了)
 * 想到dp[i][j] = min(dp[][],dp[][],dp[][])+1这个地推关系是关键
 */
class LC1277 {
  public int countSquares(int[][] matrix) {
    int res = 0;
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m + 1][n + 1];//多预留一位，防止边界溢出
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = matrix[i][j];
        } else if (matrix[i][j] == 0) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
        }
        res += dp[i][j];
      }
    }
    return res;
  }
}
