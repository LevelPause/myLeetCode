package com.hyperboat.normal.diffcult;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC1402Test {

  @Test
  void maxSatisfaction() {
    assertEquals(14, new LC1402().maxSatisfaction(new int[]{-1, -8, 0, 5, -7}));
  }
}