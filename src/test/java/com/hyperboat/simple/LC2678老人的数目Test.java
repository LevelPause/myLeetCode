package com.hyperboat.simple;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
class LC2678老人的数目Test {

  @Test
  void countSeniors() {
    assertEquals(2,new LC2678老人的数目().countSeniors(new String[]{"7868190130M7522","5303914400F9211","9273338290F4010"}));
  }
}