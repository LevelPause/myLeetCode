package com.hyperboat.面试经典150题.双指针;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC392判断子序列Test {

  @Test
  void isSubsequence() {
//    assertTrue(new LC392判断子序列().isSubsequence("abc", "ahbgdc"));
//    assertFalse(new LC392判断子序列().isSubsequence("axc", "ahbgdc"));
    assertTrue(new LC392判断子序列().isSubsequence("", "ahbgdc"));
    assertFalse(new LC392判断子序列().isSubsequence("acb", "ahbgdc"));
  }
}