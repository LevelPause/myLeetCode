package com.hyperboat.daily.y2024.m7.d22;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _2101引爆最多的炸弹Test {

  @Test
  void maximumDetonation() {
    int[][] bombs = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};
    assertEquals(5, new _2101引爆最多的炸弹().maximumDetonation(bombs));
  }
}