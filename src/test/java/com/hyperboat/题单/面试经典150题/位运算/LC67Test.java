package com.hyperboat.题单.面试经典150题.位运算;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LC67Test {

  @Test
  void addBinary() {
    assertEquals("10101",new LC67().addBinary("1010","1011"));
  }
  @Test
  void test() {
    assertEquals("100",new LC67().addBinary("11","1"));
  }
}