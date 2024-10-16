package com.hyperboat.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.数组_字符串._135分发糖果;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月21日
 */
class _135分发糖果Test {

  @Test
  void candy() {
    assertEquals(5, new _135分发糖果().candy(new int[]{1, 0, 2}));
    assertEquals(7, new _135分发糖果().candy(new int[]{1,3,2,2,1}));
    assertEquals(18, new _135分发糖果().candy(new int[]{1,6,10,8,7,3,2}));
  }
}