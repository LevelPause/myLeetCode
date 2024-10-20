package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC6Test {

  @Test
  void convert() {
    assertEquals("PAHNAPLSIIGYIR", new LC6().convert1("PAYPALISHIRING", 3));
    assertEquals("PINALSIGYAHRPI", new LC6().convert1("PAYPALISHIRING", 4));
    assertEquals("A", new LC6().convert1("A", 1));
    assertEquals("AB", new LC6().convert1("AB", 1));
    assertEquals("ACBD", new LC6().convert1("ABCD", 2));
    assertEquals("ACB", new LC6().convert1("ABC", 2));
  }
}