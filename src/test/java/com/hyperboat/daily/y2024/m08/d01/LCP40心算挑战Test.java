package com.hyperboat.daily.y2024.m08.d01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LCP40心算挑战Test {

  @Test
  void maxmiumScore() {
    assertEquals(6,new LCP40心算挑战().maxmiumScore(new int[]{5,5,6,1,9,1,2,9,1,1},1));
  }
}