package com.hyperboat.daily.y2024.m07.d31;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _3111覆盖所有点的最少矩形数目Test {

  @Test
  void minRectanglesToCoverPoints() {
    int[][] points = {{2, 1}, {1, 0}, {1, 4}, {1, 8}, {3, 5}, {4, 6}};
    int w = 2;
    assertEquals(2, new _3111覆盖所有点的最少矩形数目().minRectanglesToCoverPoints(points, w));
  }
}