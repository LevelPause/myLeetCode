package com.hyperboat.面试经典150题.回溯;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.hyperboat.题单.面试经典150题.回溯._79单词搜索;
import org.junit.jupiter.api.Test;

class _79单词搜索Test {

  @Test
  void exist() {
    char[][] board = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}};
    assertTrue(new _79单词搜索().exist(board, "ABCCED"));
  }
}