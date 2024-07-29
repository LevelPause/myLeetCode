package com.hyperboat.面试经典150题.双指针;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
class _167两数之和II输入有序数组Test {

  @Test
  void twoSum() {
    assertArrayEquals(new int[]{1, 2}, new _167两数之和II输入有序数组().twoSum(new int[]{2, 7, 11, 15}, 9));
    assertArrayEquals(new int[]{1, 3}, new _167两数之和II输入有序数组().twoSum(new int[]{2, 3, 4}, 6));
    assertArrayEquals(new int[]{1, 2}, new _167两数之和II输入有序数组().twoSum(new int[]{-1, 0}, -1));
  }
}