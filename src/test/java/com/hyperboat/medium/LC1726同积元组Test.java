package com.hyperboat.medium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月19日 4:46
 */
class LC1726同积元组Test {

  @Test
  void tupleSameProduct() {
    assertEquals(8, new LC1726同积元组().tupleSameProduct(new int[]{2, 3, 4, 6}));
  }
}