package com.hyperboat.题单.面试经典150题.矩阵;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class _73矩阵置零Test {

  @Test
  void setZeroes() {
    int[][] martix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    int[][] expected = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
    new _73矩阵置零().setZeroes(martix);
    for (int i = 0; i < martix.length; i++) {
      assertArrayEquals(expected[i], martix[i]);
    }
  }
}