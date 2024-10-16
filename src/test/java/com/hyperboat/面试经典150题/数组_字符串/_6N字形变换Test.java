package com.hyperboat.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.数组_字符串._6N字形变换;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class _6N字形变换Test {

  @Test
  void convert() {
    assertEquals("PAHNAPLSIIGYIR", new _6N字形变换().convert1("PAYPALISHIRING", 3));
    assertEquals("PINALSIGYAHRPI", new _6N字形变换().convert1("PAYPALISHIRING", 4));
    assertEquals("A", new _6N字形变换().convert1("A", 1));
    assertEquals("AB", new _6N字形变换().convert1("AB", 1));
    assertEquals("ACBD", new _6N字形变换().convert1("ABCD", 2));
    assertEquals("ACB", new _6N字形变换().convert1("ABC", 2));
  }
}