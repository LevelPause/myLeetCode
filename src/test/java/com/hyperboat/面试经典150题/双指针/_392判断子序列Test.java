package com.hyperboat.面试经典150题.双指针;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.双指针._392判断子序列;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class _392判断子序列Test {

  @Test
  void isSubsequence() {
//    assertTrue(new _392判断子序列().isSubsequence("abc", "ahbgdc"));
//    assertFalse(new _392判断子序列().isSubsequence("axc", "ahbgdc"));
    assertTrue(new _392判断子序列().isSubsequence("", "ahbgdc"));
    assertFalse(new _392判断子序列().isSubsequence("acb", "ahbgdc"));
  }
}