package com.hyperboat.题单.面试经典150题.双指针;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
class LC167Test {

  @Test
  void twoSum() {
    assertArrayEquals(new int[]{1, 2}, new LC167().twoSum(new int[]{2, 7, 11, 15}, 9));
    assertArrayEquals(new int[]{1, 3}, new LC167().twoSum(new int[]{2, 3, 4}, 6));
    assertArrayEquals(new int[]{1, 2}, new LC167().twoSum(new int[]{-1, 0}, -1));
  }
}