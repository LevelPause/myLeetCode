package com.hyperboat.hot100.栈;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hyperboat.题单.hot100.栈._84_柱状图中最大的矩形.Solution;
import org.junit.jupiter.api.Test;

class _84_柱状图中最大的矩形Test {

  @Test
  public void test() {
    assertEquals(10, new Solution().largestRectangleArea(new int[]{4, 2, 0, 3, 2, 4, 3, 4}));
    assertEquals(10, new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    assertEquals(2, new Solution().largestRectangleArea(new int[]{2, 0, 2}));
    assertEquals(3, new Solution().largestRectangleArea(new int[]{2, 1, 2}));
  }
}