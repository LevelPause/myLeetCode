package com.hyperboat.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC13罗马数字转整数Test {

  @Test
  void romanToInt() {
    assertEquals(3, new LC13罗马数字转整数().romanToInt("III"));
    assertEquals(4, new LC13罗马数字转整数().romanToInt("IV"));
    assertEquals(9, new LC13罗马数字转整数().romanToInt("IX"));
    assertEquals(58, new LC13罗马数字转整数().romanToInt("LVIII"));
    assertEquals(1994, new LC13罗马数字转整数().romanToInt("MCMXCIV"));
  }
}