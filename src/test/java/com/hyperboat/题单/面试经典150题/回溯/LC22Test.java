package com.hyperboat.题单.面试经典150题.回溯;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LC22Test {

  @Test
  void generateParenthesis() {
    List<String> expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
    assertEquals(expected, new LC22().generateParenthesis(3));
  }

  @Test
  void test2() {
    List<String> expected = List.of("()");
    assertEquals(expected, new LC22().generateParenthesis(1));
  }
}