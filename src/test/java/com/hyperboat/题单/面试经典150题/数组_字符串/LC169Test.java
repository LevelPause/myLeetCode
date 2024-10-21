package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月18日 12:10
 */
class LC169Test {

  @Test
  void majorityElement() {
    assertEquals(3,new LC169().majorityElement(new int[]{3,2,3}));
    assertEquals(2,new LC169().majorityElement(new int[]{3,2,2,2,2,2,2,3,5,7,3}));
  }
}