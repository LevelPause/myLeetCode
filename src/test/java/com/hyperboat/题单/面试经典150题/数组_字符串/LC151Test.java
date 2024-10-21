package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC151Test {

  @Test
  void reverseMessage() {
    assertEquals("blue is sky the", new LC151().reverseMessage("the sky is blue"));
    assertEquals("world hello", new LC151().reverseMessage("  hello world  "));
    assertEquals("example good a", new LC151().reverseMessage("a good   example"));
    assertEquals("", new LC151().reverseMessage(" "));
  }
}