package com.hyperboat.medium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月24日
 */
class _1155掷骰子等于目标和的方法数Test {

  @Test
  void numRollsToTarget() {
    assertEquals(1, new _1155掷骰子等于目标和的方法数().numRollsToTarget(1, 6, 3));
    assertEquals(6, new _1155掷骰子等于目标和的方法数().numRollsToTarget(2, 6, 7));
    assertEquals(222616187, new _1155掷骰子等于目标和的方法数().numRollsToTarget(30, 30, 500));
  }
}