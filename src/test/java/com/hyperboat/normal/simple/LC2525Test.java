package com.hyperboat.normal.simple;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.normal.simple.LC2525;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月20日 1:11
 */
class LC2525Test {

  @Test
  void categorizeBox() {
    assertEquals("Both", new LC2525().categorizeBox(2909, 3968, 3272, 727));
  }
}