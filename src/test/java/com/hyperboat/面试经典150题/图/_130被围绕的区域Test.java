package com.hyperboat.面试经典150题.图;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class _130被围绕的区域Test {

  @Test
  void solve() {
    char[][] expected = {
        {'O', 'X', 'X', 'O', 'X'},
        {'X', 'X', 'X', 'X', 'O'},
        {'X', 'X', 'X', 'O', 'X'},
        {'O', 'X', 'O', 'O', 'O'},
        {'X', 'X', 'O', 'X', 'O'}};
    char[][] board = {
        {'O', 'X', 'X', 'O', 'X'},
        {'X', 'O', 'O', 'X', 'O'},
        {'X', 'O', 'X', 'O', 'X'},
        {'O', 'X', 'O', 'O', 'O'},
        {'X', 'X', 'O', 'X', 'O'}};
    new _130被围绕的区域().solve(board);
    assertArrayEquals(expected, board);
  }
}