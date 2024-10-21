package com.hyperboat.题单.位运算.异或性质;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LC2429Test {

  @Test
  public void test() {
    assertEquals(3, new LC2429().minimizeXor(1, 12));
  }
}