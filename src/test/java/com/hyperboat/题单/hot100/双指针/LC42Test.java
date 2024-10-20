package com.hyperboat.题单.hot100.双指针;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LC42Test {

  @Test
  void trap() {
    int [] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    assertEquals(6,new LC42().trap(height));
  }
}