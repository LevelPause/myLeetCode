package com.hyperboat.题单.面试经典150题.哈希表;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _202快乐数Test {

  @Test
  void isHappy() {
    assertTrue(new _202快乐数().isHappy(19));
    assertFalse(new _202快乐数().isHappy(2));
  }
}