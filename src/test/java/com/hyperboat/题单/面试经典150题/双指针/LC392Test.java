package com.hyperboat.题单.面试经典150题.双指针;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC392Test {

  @Test
  void isSubsequence() {
//    assertTrue(new _392判断子序列().isSubsequence("abc", "ahbgdc"));
//    assertFalse(new _392判断子序列().isSubsequence("axc", "ahbgdc"));
    assertTrue(new LC392().isSubsequence("", "ahbgdc"));
    assertFalse(new LC392().isSubsequence("acb", "ahbgdc"));
  }
}