package com.hyperboat.面试经典150题.二分查找;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _33搜索旋转排序数组Test {

  @Test
  void search() {
    int[]nums =new int[]{4,5,6,7,0,1,2};
    assertEquals(4,new _33搜索旋转排序数组().search(nums,0));
  }
}