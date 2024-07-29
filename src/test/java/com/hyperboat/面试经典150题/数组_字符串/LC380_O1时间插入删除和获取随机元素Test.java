package com.hyperboat.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月20日 5:31
 */
class _380_O1时间插入删除和获取随机元素Test {

  @Test
  void test() {
    _380_O1时间插入删除和获取随机元素 test = new _380_O1时间插入删除和获取随机元素();
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
    _380_O1时间插入删除和获取随机元素 test = new _380_O1时间插入删除和获取随机元素();
    assertFalse(test.remove(0));
    assertFalse(test.remove(0));
    assertTrue(test.insert(0));
    test.getRandom();
    assertTrue(test.remove(0));
    assertTrue(test.insert(0));
  }

}