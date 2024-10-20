package com.hyperboat.daily.y2024.m07.d19;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LC3096Test {

  @Test
  void minimumLevels() {
    int[] possible = {0, 0, 0};
    assertEquals(1, new LC3096().minimumLevels(possible));
  }
}