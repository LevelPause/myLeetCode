package com.hyperboat.daily.y2024.m08.d02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _128直角三角形Test {

  @Test
  void numberOfRightTriangles() {
    int[][] grid = new int[][]{{1, 0, 1}, {1, 0, 0}, {1, 0, 0}};
    assertEquals(2, new _128直角三角形().numberOfRightTriangles(grid));
  }
  @Test
  void test() {
    int[][] grid = new int[][]{{1,0,0,0},{0,1,0,1},{1,0,0,0}};
    assertEquals(0, new _128直角三角形().numberOfRightTriangles(grid));
  }
}