package com.hyperboat.题单.面试经典150题.滑动窗口;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
class LC3Test {

  @Test
  void lengthOfLongestSubstring() {
    assertEquals(3, new LC3().lengthOfLongestSubstring("abcabcbb"));
    assertEquals(1, new LC3().lengthOfLongestSubstring("bbbbb"));
    assertEquals(3, new LC3().lengthOfLongestSubstring("pwwkew"));
    assertEquals(5, new LC3().lengthOfLongestSubstring("tmmzuxt"));
  }
}