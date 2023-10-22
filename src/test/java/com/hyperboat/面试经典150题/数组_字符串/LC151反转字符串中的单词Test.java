package com.hyperboat.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC151反转字符串中的单词Test {

  @Test
  void reverseMessage() {
    assertEquals("blue is sky the", new LC151反转字符串中的单词().reverseMessage("the sky is blue"));
    assertEquals("world hello", new LC151反转字符串中的单词().reverseMessage("  hello world  "));
    assertEquals("example good a", new LC151反转字符串中的单词().reverseMessage("a good   example"));
    assertEquals("", new LC151反转字符串中的单词().reverseMessage(" "));
  }
}