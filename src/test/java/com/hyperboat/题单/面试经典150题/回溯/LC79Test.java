package com.hyperboat.题单.面试经典150题.回溯;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LC79Test {

  @Test
  void exist() {
    char[][] board = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}};
    assertTrue(new LC79().exist(board, "ABCCED"));
  }
}