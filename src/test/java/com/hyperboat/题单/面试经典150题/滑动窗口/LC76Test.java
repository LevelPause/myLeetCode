package com.hyperboat.题单.面试经典150题.滑动窗口;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LC76Test {

  @Test
  void minWindow() {
    assertEquals("BANC",new LC76().minWindow("ADOBECODEBANC","ABC"));
  }
}