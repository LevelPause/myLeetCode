package com.hyperboat.题单.面试经典150题.堆;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _502IPOTest {

  @Test
  void findMaximizedCapital() {
    int []profits = new int[]{1,2,3};
    int []capital = new int[]{0,1,1};
    assertEquals(4,new _502IPO().findMaximizedCapital(2,0,profits,capital));
  }
  @Test
  void test() {
    int []profits = new int[]{1,2,3};
    int []capital = new int[]{0,1,2};
    assertEquals(6,new _502IPO().findMaximizedCapital(3,0,profits,capital));
  }
  @Test
  void test2() {
    int []profits = new int[]{1,2,3};
    int []capital = new int[]{0,1,2};
    assertEquals(6,new _502IPO().findMaximizedCapital(10,0,profits,capital));
  }
  @Test
  void test3() {
    int []profits = new int[]{1,2,3};
    int []capital = new int[]{0,9,10};
    assertEquals(1,new _502IPO().findMaximizedCapital(2,0,profits,capital));
  }
}