package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月18日 9:52
 */
class LC88Test {

  @Test
  void merge() {
    int[] res = {1, 2, 3, 0, 0, 0};
    new LC88().merge(res, 3, new int[]{2, 5, 6}, 3);
    assertArrayEquals(res, new int[]{1, 2, 2, 3, 5, 6});
    int[] res2 = new int[]{0};
    new LC88().merge(res2, 0, new int[]{1}, 1);
    assertArrayEquals(res2, new int[]{1});
  }
}