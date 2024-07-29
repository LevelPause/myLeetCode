package com.hyperboat.daily.y2024.m7.d20;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.daily.y2024.m7.d20._2850将石头分散到网格图的最少移动次数;
import org.junit.jupiter.api.Test;

class _2850将石头分散到网格图的最少移动次数Test {

  @Test
  void minimumMoves() {
    int [][] grid = {{1,3,0},{1,0,0},{1,0,3}};
    assertEquals(4,new _2850将石头分散到网格图的最少移动次数().minimumMoves(grid));
  }
}