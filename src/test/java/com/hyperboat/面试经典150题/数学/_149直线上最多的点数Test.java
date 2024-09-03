package com.hyperboat.面试经典150题.数学;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.数学._149直线上最多的点数;
import org.junit.jupiter.api.Test;

class _149直线上最多的点数Test {

  @Test
  void maxPoints() {
    int[][] points = new int[][]{{2,3},{3,3},{-5,3}};
    assertEquals(3,new _149直线上最多的点数().maxPoints(points));
  }
}