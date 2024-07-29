package com.hyperboat.daily.y2024.m7.d14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _807保持城市天际线Test {

  @Test
  void maxIncreaseKeepingSkyline() {
    int[][] grid1 = {
        {3, 0, 8, 4},
        {2, 4, 5, 7},
        {9, 2, 6, 3},
        {0, 3, 1, 0}
    };
    int[][] grid2 = {
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    };
    assertEquals(35, new _807保持城市天际线().maxIncreaseKeepingSkyline(grid1));
    assertEquals(0, new _807保持城市天际线().maxIncreaseKeepingSkyline(grid2));
  }
}