package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月18日 10:25
 */
class LC27Test {

  @Test
  void removeElement() {
    assertEquals(2, new LC27().removeElement(new int[]{3, 2, 2, 3}, 3));
    assertEquals(0, new LC27().removeElement(new int[]{1}, 1));
    assertEquals(1, new LC27().removeElement(new int[]{4,5}, 5));
  }
}