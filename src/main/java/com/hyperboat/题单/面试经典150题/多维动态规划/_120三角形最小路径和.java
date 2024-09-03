package com.hyperboat.题单.面试经典150题.多维动态规划;

import java.util.List;

/*
 * https://leetcode.cn/problems/triangle/description/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _120三角形最小路径和 {

  public int minimumTotal(List<List<Integer>> triangle) {
    return dp1(triangle);
  }

  //  自底向上
  public int dp1(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[] dp = new int[n];
    for (int i = 0; i < n; i++) {
      dp[i] = triangle.get(n - 1).get(i);
    }
    for (int i = n - 2; i >= 0; i--) {
      List<Integer> line = triangle.get(i);
      for (int j = n - 2; j > i; j--) {
        dp[j] = Math.min(dp[j], dp[j + 1]) + line.get(j);
      }
    }
    return dp[0];
  }

  //  自底向上 原地修改数组(由于是修改List, 所以性能上不如新建数组dp)
  public int dp2(List<List<Integer>> triangle) {
    int n = triangle.size();
    for (int i = n - 2; i >= 0; i--) {
      List<Integer> line = triangle.get(i);
      List<Integer> lastLine = triangle.get(i + 1);
      for (int j = 0; j <= i; j++) {
        line.set(j, Math.min(lastLine.get(j), lastLine.get(j + 1)) + line.get(j));
      }
    }
    return triangle.get(0).get(0);
  }

  //  自顶向下 二维数组
  public int dp3(List<List<Integer>> triangle) {
    int n = triangle.size();
//    dp[i][j]表示到达时的最小路径和
    int[][] dp = new int[n][n];
    dp[0][0] = triangle.get(0).get(0);
    for (int i = 1; i < n; i++) {
      List<Integer> line = triangle.get(i);
      dp[i][i] = dp[i - 1][i - 1] + line.get(i);
      dp[i][0] = dp[i - 1][0] + line.get(0);
      for (int j = i - 1; j > 0; j--) {
        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + line.get(j);
      }
    }
    int ans = dp[n - 1][0];
    for (int i = 1; i < n; i++) {
      ans = Math.min(dp[n - 1][i], ans);
    }
    return ans;
  }

  //  自顶向下 一维数组
  public int dp4(List<List<Integer>> triangle) {
    int n = triangle.size();
//    dp[i][j]表示到达时的最小路径和
    int[] dp = new int[n];
    dp[0] = triangle.get(0).get(0);
    for (int i = 1; i < n; i++) {
      List<Integer> line = triangle.get(i);
      dp[i] = dp[i - 1] + line.get(i);
      for (int j = i - 1; j > 0; j--) {
        dp[j] = Math.min(dp[j], dp[j - 1]) + line.get(j);
      }
      dp[0] = dp[0] + line.get(0);
    }
    int ans = dp[0];
    for (int i = 1; i < n; i++) {
      ans = Math.min(dp[i], ans);
    }
    return ans;
  }
}
