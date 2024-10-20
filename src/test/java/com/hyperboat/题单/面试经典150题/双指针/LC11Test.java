package com.hyperboat.题单.面试经典150题.双指针;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
class LC11Test {

  @Test
  void maxArea() {
    assertEquals(49, new LC11().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    assertEquals(1, new LC11().maxArea(new int[]{1, 1}));
    assertEquals(36, new LC11().maxArea(new int[]{2,3,10,5,7,8,9}));
  }
}