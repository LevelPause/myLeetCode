package com.hyperboat.面试经典150题.位运算;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.位运算._190颠倒二进制位;
import org.junit.jupiter.api.Test;

class _190颠倒二进制位Test {

  @Test
  void reverseBits() {
    assertEquals(964176192,new _190颠倒二进制位().reverseBits(0b00000010100101000001111010011100));
  }
}