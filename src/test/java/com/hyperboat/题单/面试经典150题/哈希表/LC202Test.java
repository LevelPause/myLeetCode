package com.hyperboat.题单.面试经典150题.哈希表;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LC202Test {

  @Test
  void isHappy() {
    assertTrue(new LC202().isHappy(19));
    assertFalse(new LC202().isHappy(2));
  }
}