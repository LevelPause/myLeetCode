package com.hyperboat.面试经典150题;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月18日 11:12
 */
class LC26删除有序数组中的重复项Test {

  @Test
  void removeDuplicates() {
    assertEquals(2,new LC26删除有序数组中的重复项().removeDuplicates(new int[]{1,1,2}));
    assertEquals(1,new LC26删除有序数组中的重复项().removeDuplicates(new int[]{0}));
  }
}