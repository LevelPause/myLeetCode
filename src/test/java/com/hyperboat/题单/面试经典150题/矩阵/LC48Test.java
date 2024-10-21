package com.hyperboat.题单.面试经典150题.矩阵;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class LC48Test {

  @Test
  void rotate() {
    int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    new LC48().rotate(matrix);
    int[][] target = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
    assertArrayEquals(target, matrix);
  }
}