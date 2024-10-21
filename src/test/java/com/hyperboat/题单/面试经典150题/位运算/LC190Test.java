package com.hyperboat.题单.面试经典150题.位运算;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LC190Test {

  @Test
  void reverseBits() {
    assertEquals(964176192, new LC190().reverseBits(0b00000010100101000001111010011100));
  }
}