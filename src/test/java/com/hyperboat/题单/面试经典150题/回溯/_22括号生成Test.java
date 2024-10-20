package com.hyperboat.题单.面试经典150题.回溯;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class _22括号生成Test {

  @Test
  void generateParenthesis() {
    List<String> expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
    assertEquals(expected,new _22括号生成().generateParenthesis(3));
  }
  @Test
  void test2() {
    List<String> expected = Arrays.asList("()");
    assertEquals(expected,new _22括号生成().generateParenthesis(1));
  }
}