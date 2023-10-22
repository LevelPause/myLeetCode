package com.hyperboat.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC58最后一个单词的长度Test {

  @Test
  void lengthOfLastWord() {
    assertEquals(5,new LC58最后一个单词的长度().lengthOfLastWord("Hello World"));
    assertEquals(4,new LC58最后一个单词的长度().lengthOfLastWord("   fly me   to   the moon  "));
    assertEquals(6,new LC58最后一个单词的长度().lengthOfLastWord("luffy is still joyboy"));
  }
}