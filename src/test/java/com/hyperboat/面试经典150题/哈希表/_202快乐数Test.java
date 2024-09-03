package com.hyperboat.面试经典150题.哈希表;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.哈希表._202快乐数;
import org.junit.jupiter.api.Test;

class _202快乐数Test {

  @Test
  void isHappy() {
    assertTrue(new _202快乐数().isHappy(19));
    assertFalse(new _202快乐数().isHappy(2));
  }
}