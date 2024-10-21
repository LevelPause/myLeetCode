package com.hyperboat.题单.面试经典150题.堆;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LC215Test {

  @Test
  void minHeapSelect() {
    int[] nums = new int[]{3, 2, 1, 5, 6, 4};
    assertEquals(5, new LC215().minHeapSelect(nums, 2));
  }

  @Test
  void test() {
    int[] nums = new int[]{7, 6, 5, 4, 3, 2, 1};
    assertEquals(3, new LC215().minHeapSelect(nums, 5));
  }
}