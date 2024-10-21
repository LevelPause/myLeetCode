package com.hyperboat.题单.面试经典150题.双指针;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC125Test {

  @Test
  void isPalindrome() {
    assertTrue(new LC125().isPalindrome("A man, a plan, a canal: Panama"));
    assertFalse(new LC125().isPalindrome("race a car"));
    assertTrue(new LC125().isPalindrome(" "));
    assertTrue(new LC125().isPalindrome(".,"));
  }
}