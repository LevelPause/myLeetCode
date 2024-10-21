package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC58Test {

  @Test
  void lengthOfLastWord() {
    assertEquals(5,new LC58().lengthOfLastWord("Hello World"));
    assertEquals(4,new LC58().lengthOfLastWord("   fly me   to   the moon  "));
    assertEquals(6,new LC58().lengthOfLastWord("luffy is still joyboy"));
  }
}