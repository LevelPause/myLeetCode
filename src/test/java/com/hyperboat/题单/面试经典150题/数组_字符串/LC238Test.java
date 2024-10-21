package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月20日 6:12
 */
class LC238Test {

  @Test
  void productExceptSelf() {
    assertArrayEquals(new int[]{24, 12, 8, 6},
        new LC238().productExceptSelf1(new int[]{1, 2, 3, 4}));
    assertArrayEquals(new int[]{24, 12, 8, 6},
        new LC238().productExceptSelf(new int[]{1, 2, 3, 4}));
  }
}