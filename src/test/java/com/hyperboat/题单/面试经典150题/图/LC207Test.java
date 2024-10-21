package com.hyperboat.题单.面试经典150题.图;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LC207Test {

  @Test
  void canFinish() {
    assertTrue(new LC207().canFinish(2, new int[][]{{1, 0}}));
    assertTrue(new LC207().canFinish(2, new int[][]{{0, 1}}));
    assertFalse(new LC207().canFinish(2, new int[][]{{0, 1}, {1, 0}}));
    assertFalse(new LC207().canFinish(4, new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}}));
  }
}