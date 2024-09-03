package com.hyperboat.面试经典150题.滑动窗口;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.滑动窗口._76最小覆盖子串;
import org.junit.jupiter.api.Test;

class _76最小覆盖子串Test {

  @Test
  void minWindow() {
    assertEquals("BANC",new _76最小覆盖子串().minWindow("ADOBECODEBANC","ABC"));
  }
}