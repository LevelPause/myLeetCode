package com.hyperboat.normal.medium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月24日
 */
public class LC1155Test {

  @Test
  void numRollsToTarget() {
    assertEquals(1, new LC1155().numRollsToTarget(1, 6, 3));
    assertEquals(6, new LC1155().numRollsToTarget(2, 6, 7));
    assertEquals(222616187, new LC1155().numRollsToTarget(30, 30, 500));
  }
}