package com.hyperboat.题单.面试经典150题.堆;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _215数组中的第K个最大元素Test {

  @Test
  void minHeapSelect() {
    int[]nums = new int[]{3,2,1,5,6,4};
    assertEquals(5,new _215数组中的第K个最大元素().minHeapSelect(nums,2));
  }
  @Test
  void test() {
    int[]nums = new int[]{7,6,5,4,3,2,1};
    assertEquals(3,new _215数组中的第K个最大元素().minHeapSelect(nums,5));
  }
}