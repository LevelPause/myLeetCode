package com.hyperboat.daily.y2024.m10.d19;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LC3192Test {

  @Test
  void minOperations() {
    assertEquals(4,new LC3192().minOperations(new int[]{0,1,1,0,1}));
    assertEquals(1,new LC3192().minOperations(new int[]{1,0,0,0}));
  }
}