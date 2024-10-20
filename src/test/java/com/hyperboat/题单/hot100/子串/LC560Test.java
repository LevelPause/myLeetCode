package com.hyperboat.题单.hot100.子串;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LC560Test {

  @Test
  void subarraySum() {
    int[] nums = new int[]{1, 1, 1};
    int k = 2;
    assertEquals(2, new LC560().subarraySum(nums, k));
  }
  @Test
  void test() {
    int[] nums = new int[]{1};
    int k = 0;
    assertEquals(0, new LC560().subarraySum(nums, k));
  }
}