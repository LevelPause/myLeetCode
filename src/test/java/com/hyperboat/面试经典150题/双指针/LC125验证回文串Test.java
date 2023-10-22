package com.hyperboat.面试经典150题.双指针;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC125验证回文串Test {

  @Test
  void isPalindrome() {
    assertTrue(new LC125验证回文串().isPalindrome("A man, a plan, a canal: Panama"));
    assertFalse(new LC125验证回文串().isPalindrome("race a car"));
    assertTrue(new LC125验证回文串().isPalindrome(" "));
    assertTrue(new LC125验证回文串().isPalindrome(".,"));
  }
}