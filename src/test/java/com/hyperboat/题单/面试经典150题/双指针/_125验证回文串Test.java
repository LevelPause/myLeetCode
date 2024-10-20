package com.hyperboat.题单.面试经典150题.双指针;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class _125验证回文串Test {

  @Test
  void isPalindrome() {
    assertTrue(new _125验证回文串().isPalindrome("A man, a plan, a canal: Panama"));
    assertFalse(new _125验证回文串().isPalindrome("race a car"));
    assertTrue(new _125验证回文串().isPalindrome(" "));
    assertTrue(new _125验证回文串().isPalindrome(".,"));
  }
}