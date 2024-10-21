package com.hyperboat.题单.面试经典150题.多维动态规划;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LC64Test {

  @Test
  void minPathSum() {
    int[][] grid = new int[][]{
        {1, 2, 3},
        {4, 5, 6}};
    assertEquals(12, new LC64().minPathSum(grid));
  }
}