package com.hyperboat.daily.y2024.m08.d30;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LC3153Test {

  @Test
  public void test() {
    assertEquals(4, new LC3153.Solution().sumDigitDifferences(new int[]{13, 23, 12}));
    assertEquals(5, new LC3153.Solution().sumDigitDifferences(new int[]{50, 28, 48}));
    assertEquals(67, new LC3153.Solution().sumDigitDifferences(new int[]{824,843,837,620,836,234,276,859}));
  }
}