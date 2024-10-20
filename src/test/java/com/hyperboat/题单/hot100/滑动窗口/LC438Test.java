package com.hyperboat.题单.hot100.滑动窗口;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LC438Test {

  @Test
  void normal2() {
    assertEquals(Arrays.asList(0,6),new LC438().normal2("cbaebabacd","abc"));
  }
}