package com.hyperboat.面试经典150题.LC169;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月18日 12:10
 */
class LC169多数元素Test {

  @Test
  void majorityElement() {
    assertEquals(3,new LC169多数元素().majorityElement(new int[]{3,2,3}));
    assertEquals(2,new LC169多数元素().majorityElement(new int[]{3,2,2,2,2,2,2,3,5,7,3}));
  }
}