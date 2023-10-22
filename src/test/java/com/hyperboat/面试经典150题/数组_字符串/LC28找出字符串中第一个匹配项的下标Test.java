package com.hyperboat.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC28找出字符串中第一个匹配项的下标Test {

  @Test
  void strStr() {
//    assertEquals(0, new LC28找出字符串中第一个匹配项的下标().strStr("sadbutsad", "sad"));
//    assertEquals(-1, new LC28找出字符串中第一个匹配项的下标().strStr("leetcode", "leeto"));
    assertEquals(4, new LC28找出字符串中第一个匹配项的下标().strStr("mississippi", "issip"));
    assertEquals(4, new LC28找出字符串中第一个匹配项的下标().strStr("mississippi", "issipi"));
  }
}