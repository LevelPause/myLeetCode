package com.hyperboat.题单.面试经典150题.堆;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LC502Test {

  @Test
  void findMaximizedCapital() {
    int[] profits = new int[]{1, 2, 3};
    int[] capital = new int[]{0, 1, 1};
    assertEquals(4, new LC502().findMaximizedCapital(2, 0, profits, capital));
  }

  @Test
  void test() {
    int[] profits = new int[]{1, 2, 3};
    int[] capital = new int[]{0, 1, 2};
    assertEquals(6, new LC502().findMaximizedCapital(3, 0, profits, capital));
  }

  @Test
  void test2() {
    int[] profits = new int[]{1, 2, 3};
    int[] capital = new int[]{0, 1, 2};
    assertEquals(6, new LC502().findMaximizedCapital(10, 0, profits, capital));
  }

  @Test
  void test3() {
    int[] profits = new int[]{1, 2, 3};
    int[] capital = new int[]{0, 9, 10};
    assertEquals(1, new LC502().findMaximizedCapital(2, 0, profits, capital));
  }
}