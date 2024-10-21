package com.hyperboat.题单.面试经典150题.图;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class LC130Test {

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
    new LC130().solve(board);
    assertArrayEquals(expected, board);
  }
}