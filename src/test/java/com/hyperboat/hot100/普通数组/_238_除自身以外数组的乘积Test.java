package com.hyperboat.hot100.普通数组;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.hot100.普通数组._238_除自身以外数组的乘积;
import org.junit.jupiter.api.Test;

class _238_除自身以外数组的乘积Test {

  @Test
  void productExceptSelf() {
    int[] excepted  =new int[]{24,12,8,6};
    int [] nums = new int[]{1,2,3,4};
    assertArrayEquals(excepted,new _238_除自身以外数组的乘积().productExceptSelf(nums));
  }
}