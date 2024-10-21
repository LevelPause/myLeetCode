package com.hyperboat.题单.面试经典150题.滑动窗口;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
class LC209Test {

  @Test
  void minSubArrayLen() {
    assertEquals(2,new LC209().minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    assertEquals(1,new LC209().minSubArrayLen(4,new int[]{1,4,4}));
    assertEquals(0,new LC209().minSubArrayLen(11,new int[]{1,1,1,1,1,1,1,1}));
    assertEquals(3,new LC209().minSubArrayLen(11,new int[]{1,2,3,4,5}));
  }
}