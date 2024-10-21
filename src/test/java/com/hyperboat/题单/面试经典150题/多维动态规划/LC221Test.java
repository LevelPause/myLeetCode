package com.hyperboat.题单.面试经典150题.多维动态规划;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LC221Test {

  @Test
  void maximalSquare() {
    char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
    assertEquals(4, new LC221().maximalSquare(matrix));
  }

  @Test
  void test() {

    char[][] matrix = new char[][]{
        {'1', '1', '1', '1', '1', '1', '1', '1'},
        {'1', '1', '1', '1', '1', '1', '1', '0'},
        {'1', '1', '1', '1', '1', '1', '1', '0'},
        {'1', '1', '1', '1', '1', '0', '0', '0'},
        {'0', '1', '1', '1', '1', '0', '0', '0'}};
    assertEquals(16, new LC221().maximalSquare(matrix));
  }
}