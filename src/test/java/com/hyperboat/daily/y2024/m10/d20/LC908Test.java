package com.hyperboat.daily.y2024.m10.d20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LC908Test {

  @Test
  void smallestRangeI() {
    assertEquals(0, new LC908().smallestRangeI(new int[]{1}, 0));
    assertEquals(6, new LC908().smallestRangeI(new int[]{0, 10}, 2));
    assertEquals(0, new LC908().smallestRangeI(new int[]{1, 3, 6}, 3));
  }
}