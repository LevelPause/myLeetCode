package com.hyperboat.题单.hot100.普通数组;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LC238Test {

  @Test
  void productExceptSelf() {
    int[] excepted  =new int[]{24,12,8,6};
    int [] nums = new int[]{1,2,3,4};
    assertArrayEquals(excepted,new LC238().productExceptSelf(nums));
  }
}