package com.hyperboat.面试经典150题.滑动窗口;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
class LC3无重复字符的最长子串Test {

  @Test
  void lengthOfLongestSubstring() {
    assertEquals(3, new LC3无重复字符的最长子串().lengthOfLongestSubstring("abcabcbb"));
    assertEquals(1, new LC3无重复字符的最长子串().lengthOfLongestSubstring("bbbbb"));
    assertEquals(3, new LC3无重复字符的最长子串().lengthOfLongestSubstring("pwwkew"));
    assertEquals(5, new LC3无重复字符的最长子串().lengthOfLongestSubstring("tmmzuxt"));
  }
}