package com.hyperboat.题单.面试经典150题.栈;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LC150Test {

  @Test
  void evalRPN() {
    assertEquals(9,new LC150().evalRPN(new String[]{"2","1","+","3","*"}));
    assertEquals(6,new LC150().evalRPN(new String[]{"4","13","5","/","+"}));
    assertEquals(22,new LC150().evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
  }
}