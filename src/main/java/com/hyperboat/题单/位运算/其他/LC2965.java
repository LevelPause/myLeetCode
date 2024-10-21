package com.hyperboat.题单.位运算.其他;

/**
 * 2965. 找出缺失和重复的数字
 * <p>
 * https://leetcode.cn/problems/find-missing-and-repeated-values/description/
 */
class LC2965 {

  //设 重复的元素为a, 缺失的元素为b
  public int[] findMissingAndRepeatedValues(int[][] grid) {
    // 1到n的累加和
    var sumN = 0;
    // 1²到n²的累加和
    var sumN2 = 0L;
    //grid[i][j]的累加和
    var sumX = 0;
    //grid[i][j]²的累加和
    var sumX2 = 0L;
    var n = grid.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        var x = grid[i][j];
        sumN += i * n + j + 1;
        sumN2 += ((long) i * n + j + 1) * ((long) i * n + j + 1);
        sumX += x;
        sumX2 += (long) x * x;
      }
    }
    // a-b
    var d1 = sumX - sumN;
    // a²+b²
    var d2 = sumX2 - sumN2;
    // a+b
    var d = d2 / d1;
    return new int[]{(int) ((d + d1) / 2), (int) ((d - d1) / 2)};
  }

}
