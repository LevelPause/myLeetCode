package com.hyperboat.面试经典150题.双指针;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.双指针._11盛最多水的容器;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
class _11盛最多水的容器Test {

  @Test
  void maxArea() {
    assertEquals(49, new _11盛最多水的容器().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    assertEquals(1, new _11盛最多水的容器().maxArea(new int[]{1, 1}));
    assertEquals(36, new _11盛最多水的容器().maxArea(new int[]{2,3,10,5,7,8,9}));
  }
}