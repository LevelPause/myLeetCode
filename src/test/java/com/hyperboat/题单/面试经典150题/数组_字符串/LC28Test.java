package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC28Test {

  @Test
  void strStr() {
//    assertEquals(0, new LC28().strStr("sadbutsad", "sad"));
//    assertEquals(-1, new LC28().strStr("leetcode", "leeto"));
    assertEquals(4, new LC28().strStr("mississippi", "issip"));
    assertEquals(-1, new LC28().strStr("mississippi", "issipi"));
  }
}