package com.hyperboat.题单.面试经典150题.多维动态规划;

/*
 * https://leetcode.cn/problems/unique-paths-ii/?envType=study-plan-v2&envId=top-interview-150
 * */
class LC63 {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int n = obstacleGrid[0].length;
//    dp[j]表示到达当前行的第j列所用的路径方法数
    int[] dp = new int[n];
    dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
    for (int[] ints : obstacleGrid) {
      for (int j = 0; j < n; j++) {
        if (ints[j] == 1) {
          dp[j] = 1;
          continue;
        }
        if (j > 0 && ints[j] == 0) {
          dp[j] += dp[j - 1];
        }
      }
    }
    return dp[n - 1];
  }
}
