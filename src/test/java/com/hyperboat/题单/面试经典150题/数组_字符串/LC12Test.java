package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC12Test {

  @Test
  void intToRoman() {
    assertEquals("III",new LC12().intToRoman(3));
    assertEquals("IV",new LC12().intToRoman(4));
    assertEquals("IX",new LC12().intToRoman(9));
    assertEquals("LVIII",new LC12().intToRoman(58));
    assertEquals("MCMXCIV",new LC12().intToRoman(1994));
  }
}