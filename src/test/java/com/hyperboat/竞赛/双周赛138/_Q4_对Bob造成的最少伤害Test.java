package com.hyperboat.竞赛.双周赛138;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _Q4_对Bob造成的最少伤害Test {

  @Test
  public void test() {
    assertEquals(39,
        new _Q4_对Bob造成的最少伤害.Solution().minDamage(4, new int[]{1, 2, 3, 4}, new int[]{4, 5, 6, 8}));
  }
}