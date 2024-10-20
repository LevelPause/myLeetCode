package com.hyperboat.daily.y2024.m07.d27;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LC3106Test {

  @Test
  void getSmallestString() {
    assertEquals("aawcd",new LC3106().getSmallestString("xaxcd",4));
    assertEquals("a",new LC3106().getSmallestString("a",26));
  }
}