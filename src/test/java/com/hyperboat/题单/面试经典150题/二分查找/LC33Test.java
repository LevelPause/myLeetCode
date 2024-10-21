package com.hyperboat.题单.面试经典150题.二分查找;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LC33Test {

  @Test
  void search() {
    int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
    assertEquals(4, new LC33().search(nums, 0));
  }
}