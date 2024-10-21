package com.hyperboat.题单.面试经典150题.数学;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LC149Test {

  @Test
  void maxPoints() {
    int[][] points = new int[][]{{2, 3}, {3, 3}, {-5, 3}};
    assertEquals(3, new LC149().maxPoints(points));
  }
}