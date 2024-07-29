package com.hyperboat.daily.y2024.m7.d27;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _3106满足距离约束且字典序最小的字符串Test {

  @Test
  void getSmallestString() {
    assertEquals("aawcd",new _3106满足距离约束且字典序最小的字符串().getSmallestString("xaxcd",4));
    assertEquals("a",new _3106满足距离约束且字典序最小的字符串().getSmallestString("a",26));
  }
}