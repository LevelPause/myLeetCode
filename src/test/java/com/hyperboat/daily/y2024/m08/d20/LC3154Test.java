package com.hyperboat.daily.y2024.m08.d20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LC3154Test {

  @Test
  public void test() {
    assertEquals(2, new LC3154.Solution().waysToReachStair(0));
    assertEquals(4, new LC3154.Solution().waysToReachStair(1));
    assertEquals(3, new LC3154.Solution().waysToReachStair(3));
  }
}