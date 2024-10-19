package com.hyperboat.normal.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LC1319Test {

  @Test
  void test() {
    int[][] connections = {{0, 1}, {0, 2}, {3, 4}, {2, 3}};
    assertEquals(0, new LC1319().makeConnected(5, connections));
  }
  @Test
  void test2() {
    int[][] connections = {{0, 1}, {0, 2}, {1, 2}};
    assertEquals(1, new LC1319().makeConnected(4, connections));
  }
  @Test
  void test3() {
    int[][] connections = {{1,5},{1,7},{1,2},{1,4},{3,7},{4,7},{3,5},{0,6},{0,1},{0,4},{2,6},{0,3},{0,2}};
    assertEquals(4, new LC1319().makeConnected(12, connections));
  }
}