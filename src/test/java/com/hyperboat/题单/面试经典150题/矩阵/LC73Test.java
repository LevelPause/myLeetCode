package com.hyperboat.题单.面试经典150题.矩阵;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class LC73Test {

  @Test
  void setZeroes() {
    int[][] martix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    int[][] expected = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
    new LC73().setZeroes(martix);
    for (int i = 0; i < martix.length; i++) {
      assertArrayEquals(expected[i], martix[i]);
    }
  }
}