package com.hyperboat.竞赛.周赛416;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.竞赛.周赛416._Q3_Q4_统计重新排列后包含另一个字符串的子字符串数目I.Solution;
import org.junit.jupiter.api.Test;

class _Q3_Q4_统计重新排列后包含另一个字符串的子字符串数目ITest {

  @Test
  public void test() {
    assertEquals(1, new Solution().validSubstringCount("bcca", "abc"));
    assertEquals(10, new Solution().validSubstringCount("abcabc", "abc"));
    assertEquals(18, new Solution().validSubstringCount("dcbdcdccb", "cdd"));
  }
}