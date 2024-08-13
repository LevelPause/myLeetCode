package com.hyperboat.hot100.滑动窗口;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class _438_找到字符串中所有字母异位词Test {

  @Test
  void normal2() {
    assertEquals(Arrays.asList(0,6),new _438_找到字符串中所有字母异位词().normal2("cbaebabacd","abc"));
  }
}