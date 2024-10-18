package com.hyperboat.daily.y2024.m08.d19;

public class LC552 {

  class Solution {

    public int checkRecord(int n) {
      return checkRecord2(n);
    }

    /*空间复杂度O(n)*/
    public int checkRecord2(int n) {
      /*dp[i][j][k]表示第i天共缺席j次连续迟到k次,因此j取值范围[0,2),k取值范围[0,3)*/
      /*第0天初始化为1*/
      int MOD = (int) 1e9 + 7;
      int[][][] dp = new int[n + 1][2][3];
      dp[0][0][0] = 1;
      for (int i = 1; i < n + 1; i++) {
        /*以P结尾*/
        for (int j = 0; j < 2; j++) {
          for (int k = 0; k < 3; k++) {
            dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
          }
        }
        /*以A结尾*/
        for (int k = 0; k < 3; k++) {
          dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % MOD;
        }
        /*以L结尾*/
        for (int j = 0; j < 2; j++) {
          for (int k = 1; k < 3; k++) {
            dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
          }
        }
      }
      int sum = 0;
      for (int j = 0; j < 2; j++) {
        for (int k = 0; k < 3; k++) {
          sum = (sum + dp[n][j][k]) % MOD;
        }
      }
      return sum;

    }

    /*空间复杂度O(1)*/
    public int checkRecord3(int n) {
      /*dp[i][j][k]表示第i天共缺席j次连续迟到k次,因此j取值范围[0,2),k取值范围[0,3)*/
      /*因为dp[i]只通过dp[i-1]转移, 所以可通过滚动数组将空间复杂度优化为O(1)*/
      /*第0天初始化为1*/
      int MOD = (int) 1e9 + 7;
      int[][] dp = new int[2][3];
      dp[0][0] = 1;
      for (int i = 1; i < n + 1; i++) {
        int[][] curr = new int[2][3];
        /*以P结尾*/
        for (int j = 0; j < 2; j++) {
          for (int k = 0; k < 3; k++) {
            curr[j][0] = (curr[j][0] + dp[j][k]) % MOD;
          }
        }
        /*以A结尾*/
        for (int k = 0; k < 3; k++) {
          curr[1][0] = (curr[1][0] + dp[0][k]) % MOD;
        }
        /*以L结尾*/
        for (int j = 0; j < 2; j++) {
          for (int k = 1; k < 3; k++) {
            curr[j][k] = (curr[j][k] + dp[j][k - 1]) % MOD;
          }
        }
        dp = curr;
      }
      int sum = 0;
      for (int j = 0; j < 2; j++) {
        for (int k = 0; k < 3; k++) {
          sum = (sum + dp[j][k]) % MOD;
        }
      }
      return sum;

    }
  }

}
