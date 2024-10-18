package com.hyperboat.daily.y2024.m08.d02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LC3128Test {

  @Test
  void numberOfRightTriangles() {
    int[][] grid = new int[][]{{1, 0, 1}, {1, 0, 0}, {1, 0, 0}};
    assertEquals(2, new LC3128().numberOfRightTriangles(grid));
  }
  @Test
  void test() {
    int[][] grid = new int[][]{{1,0,0,0},{0,1,0,1},{1,0,0,0}};
    assertEquals(0, new LC3128().numberOfRightTriangles(grid));
  }
}