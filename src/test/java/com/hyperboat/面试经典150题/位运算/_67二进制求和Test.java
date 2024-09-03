package com.hyperboat.面试经典150题.位运算;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.位运算._67二进制求和;
import org.junit.jupiter.api.Test;

class _67二进制求和Test {

  @Test
  void addBinary() {
    assertEquals("10101",new _67二进制求和().addBinary("1010","1011"));
  }
  @Test
  void test() {
    assertEquals("100",new _67二进制求和().addBinary("11","1"));
  }
}