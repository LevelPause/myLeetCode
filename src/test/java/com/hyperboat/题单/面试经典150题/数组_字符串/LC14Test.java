package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC14Test {

  @Test
  void longestCommonPrefix() {
    assertEquals("", new LC14().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    assertEquals("fl",
        new LC14().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
  }
}