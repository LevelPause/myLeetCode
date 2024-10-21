package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月20日 23:24
 */
class LC134Test {

  @Test
  void canCompleteCircuit() {
    assertEquals(3,
        new LC134().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    assertEquals(-1, new LC134().canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
  }
}