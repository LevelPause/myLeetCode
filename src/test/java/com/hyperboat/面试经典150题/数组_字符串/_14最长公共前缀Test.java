package com.hyperboat.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.数组_字符串._14最长公共前缀;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class _14最长公共前缀Test {

  @Test
  void longestCommonPrefix() {
    assertEquals("", new _14最长公共前缀().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    assertEquals("fl",
        new _14最长公共前缀().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
  }
}