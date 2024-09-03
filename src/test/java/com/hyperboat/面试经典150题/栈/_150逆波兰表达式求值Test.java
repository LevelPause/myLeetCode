package com.hyperboat.面试经典150题.栈;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.栈._150逆波兰表达式求值;
import org.junit.jupiter.api.Test;

class _150逆波兰表达式求值Test {

  @Test
  void evalRPN() {
    assertEquals(9,new _150逆波兰表达式求值().evalRPN(new String[]{"2","1","+","3","*"}));
    assertEquals(6,new _150逆波兰表达式求值().evalRPN(new String[]{"4","13","5","/","+"}));
    assertEquals(22,new _150逆波兰表达式求值().evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
  }
}