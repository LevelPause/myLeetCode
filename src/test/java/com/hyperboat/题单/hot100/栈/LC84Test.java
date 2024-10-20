package com.hyperboat.题单.hot100.栈;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LC84Test {

  @Test
  public void test() {
    assertEquals(10, new LC84().largestRectangleArea(new int[]{4, 2, 0, 3, 2, 4, 3, 4}));
    assertEquals(10, new LC84().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    assertEquals(2, new LC84().largestRectangleArea(new int[]{2, 0, 2}));
    assertEquals(3, new LC84().largestRectangleArea(new int[]{2, 1, 2}));
  }
}