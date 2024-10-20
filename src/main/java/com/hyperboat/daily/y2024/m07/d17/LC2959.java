package com.hyperboat.daily.y2024.m07.d17;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/number-of-possible-sets-of-closing-branches/description/
 * */
class LC2959 {

  public int numberOfSets(int n, int maxDistance, int[][] roads) {
    int[][] m = new int[n][n];
    int ans = 0;
    int[] opened = new int[n];
    //枚举所有关闭的方案
    for (int mask = 0; mask < (1 << n); mask++) {
      //初始化门店开关状态
      for (int i = 0; i < n; i++) {
        opened[i] = mask & (1 << i);
      }
      //初始化门店距离矩阵
      for (int i = 0; i < n; i++) {
        int[] row = m[i];
        Arrays.fill(row, 100000);
      }
      //填充矩阵
      for (int[] road : roads) {
        int i = road[0];
        int j = road[1];
        int distance = road[2];
        if (opened[i] > 0 && opened[j] > 0) {
          m[i][j] = m[j][i] = Math.min(m[i][j], distance);
        }
      }
      /*floyd算法，寻找多源最短路径*/
      for (int k = 0; k < n; k++) {
        if (opened[k] > 0) {
          for (int i = 0; i < n; i++) {
            if (opened[i] > 0) {
              for (int j = i + 1; j < n; j++) {
                if (opened[j] > 0) {
                  m[i][j] = m[j][i] = Math.min(m[i][j], m[i][k] + m[k][j]);
                }
              }
            }
          }
        }
      }

      boolean success = true;
      //计算此次方案是否有超出maxDistance距离的门店
      for (int i = 0; success && i < n; i++) {
        if (opened[i] > 0) {
          for (int j = i + 1; success && j < n; j++) {
            if (opened[i] > 0) {
              if (m[i][j] > maxDistance) {
                success = false;
              }
            }
          }
        }
      }
      /*将符合条件的方案加上*/
      ans += success ? 1 : 0;
    }
    return ans;
  }
}
