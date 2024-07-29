package com.hyperboat.diffcult;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class _1402做菜顺序Test {

  @Test
  void maxSatisfaction() {
    assertEquals(14, new _1402做菜顺序().maxSatisfaction(new int[]{-1, -8, 0, 5, -7}));
  }
}