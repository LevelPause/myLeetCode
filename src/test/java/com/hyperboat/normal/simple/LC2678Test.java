package com.hyperboat.normal.simple;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.normal.simple.LC2678;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
public class LC2678Test {

  @Test
  void countSeniors() {
    assertEquals(2,new LC2678().countSeniors(new String[]{"7868190130M7522","5303914400F9211","9273338290F4010"}));
  }
}