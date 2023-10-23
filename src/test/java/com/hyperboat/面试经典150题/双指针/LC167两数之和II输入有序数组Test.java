package com.hyperboat.面试经典150题.双指针;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
class LC167两数之和II输入有序数组Test {

  @Test
  void twoSum() {
    assertArrayEquals(new int[]{1, 3}, new LC167两数之和II输入有序数组().twoSum(new int[]{1, 2, 4, 6, 10}, 8));
    assertArrayEquals(new int[]{0, 2}, new LC167两数之和II输入有序数组().twoSum(new int[]{2, 3, 4}, 6));
    assertArrayEquals(new int[]{0, 1}, new LC167两数之和II输入有序数组().twoSum(new int[]{-1, 0}, -1));
  }
}