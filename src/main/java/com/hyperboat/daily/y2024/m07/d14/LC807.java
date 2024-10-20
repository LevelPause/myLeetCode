package com.hyperboat.daily.y2024.m07.d14;

class LC807 {

  // 贪心思想，使每个方格增长为 Min(行最大值,列最大值) 即可
  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int ans = 0;
    int rows = grid.length;
    int cols = grid[0].length;
    int[] rowMax = new int[rows];
    int[] colMax = new int[cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        rowMax[i] = Math.max(rowMax[i], grid[i][j]);
        colMax[j] = Math.max(colMax[j], grid[i][j]);
      }
    }
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int tempMin = Math.min(rowMax[i], colMax[j]);
//        System.out.print(tempMin+",");
        if (tempMin > grid[i][j]) {
          ans += tempMin - grid[i][j];
        }
      }
//      System.out.println("");
    }
    return ans;
  }
}
