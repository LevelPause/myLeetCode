package com.hyperboat.daily.y2024.m10.d18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LC3191Test {

  @Test
  void minOperations() {
    assertEquals(3, new LC3191().minOperations(new int[]{0, 1, 1, 1, 0, 0}));
    assertEquals(-1, new LC3191().minOperations(new int[]{0, 1, 1, 1}));
  }
}