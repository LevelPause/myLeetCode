package com.hyperboat.面试经典150题.哈希表;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.哈希表._205同构字符串;
import org.junit.jupiter.api.Test;

class _205同构字符串Test {

  @Test
  void isIsomorphic() {
    assertTrue(new _205同构字符串().isIsomorphic("egg","add"));
    assertFalse(new _205同构字符串().isIsomorphic("badc","baba"));
  }
}