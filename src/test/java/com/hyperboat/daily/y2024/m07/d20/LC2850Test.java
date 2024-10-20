package com.hyperboat.daily.y2024.m07.d20;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LC2850Test {

  @Test
  void minimumMoves() {
    int [][] grid = {{1,3,0},{1,0,0},{1,0,3}};
    assertEquals(4,new LC2850().minimumMoves(grid));
  }
}