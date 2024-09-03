package com.hyperboat.hot100.子串;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hyperboat.题单.hot100.子串._560_和为K的子数组;
import org.junit.jupiter.api.Test;

class _560_和为K的子数组Test {

  @Test
  void subarraySum() {
    int[] nums = new int[]{1, 1, 1};
    int k = 2;
    assertEquals(2, new _560_和为K的子数组().subarraySum(nums, k));
  }
  @Test
  void test() {
    int[] nums = new int[]{1};
    int k = 0;
    assertEquals(0, new _560_和为K的子数组().subarraySum(nums, k));
  }
}