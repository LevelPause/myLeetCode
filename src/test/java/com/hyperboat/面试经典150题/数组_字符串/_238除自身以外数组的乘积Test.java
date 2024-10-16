package com.hyperboat.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.数组_字符串._238除自身以外数组的乘积;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月20日 6:12
 */
class _238除自身以外数组的乘积Test {

  @Test
  void productExceptSelf() {
    assertArrayEquals(new int[]{24, 12, 8, 6},
        new _238除自身以外数组的乘积().productExceptSelf1(new int[]{1, 2, 3, 4}));
    assertArrayEquals(new int[]{24, 12, 8, 6},
        new _238除自身以外数组的乘积().productExceptSelf(new int[]{1, 2, 3, 4}));
  }
}