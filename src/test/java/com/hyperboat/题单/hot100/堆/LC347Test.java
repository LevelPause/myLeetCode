package com.hyperboat.题单.hot100.堆;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class LC347Test {

  @Test
  public void test() {
    assertArrayEquals(new int[]{1, 2}, new LC347().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
  }
}