package com.hyperboat.daily.y2024.m10.d21;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LC910Test {

  @Test
  void smallestRangeII() {
    assertEquals(0, new LC910().smallestRangeII(new int[]{1}, 0));
    assertEquals(6, new LC910().smallestRangeII(new int[]{0, 10}, 2));
    assertEquals(3, new LC910().smallestRangeII(new int[]{1, 3, 6}, 3));
  }
}