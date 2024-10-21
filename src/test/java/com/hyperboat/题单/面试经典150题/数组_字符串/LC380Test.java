package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月20日 5:31
 */
class LC380Test {

  @Test
  void test() {
    LC380 test = new LC380();
    assertTrue(test.insert(1));
    assertFalse(test.remove(2));
    assertTrue(test.insert(2));
    test.getRandom();
    assertTrue(test.remove(1));
    assertFalse(test.insert(2));
    assertEquals(2, test.getRandom());
  }
  @Test
  void test2() {
    LC380 test = new LC380();
    assertFalse(test.remove(0));
    assertFalse(test.remove(0));
    assertTrue(test.insert(0));
    test.getRandom();
    assertTrue(test.remove(0));
    assertTrue(test.insert(0));
  }

}