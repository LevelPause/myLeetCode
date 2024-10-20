package com.hyperboat.题单.hot100.回溯;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LC22Test {

  @Test
  public void test() {
    assertEquals(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"),
        new LC22().generateParenthesis(3));
  }
}