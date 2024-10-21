package com.hyperboat.题单.面试经典150题.哈希表;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LC205Test {

  @Test
  void isIsomorphic() {
    assertTrue(new LC205().isIsomorphic("egg", "add"));
    assertFalse(new LC205().isIsomorphic("badc", "baba"));
  }
}