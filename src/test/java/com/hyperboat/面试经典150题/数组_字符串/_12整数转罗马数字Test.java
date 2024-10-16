package com.hyperboat.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.数组_字符串._12整数转罗马数字;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class _12整数转罗马数字Test {

  @Test
  void intToRoman() {
    assertEquals("III",new _12整数转罗马数字().intToRoman(3));
    assertEquals("IV",new _12整数转罗马数字().intToRoman(4));
    assertEquals("IX",new _12整数转罗马数字().intToRoman(9));
    assertEquals("LVIII",new _12整数转罗马数字().intToRoman(58));
    assertEquals("MCMXCIV",new _12整数转罗马数字().intToRoman(1994));
  }
}