package com.hyperboat.hot100.回溯;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.hot100.回溯._22_括号生成;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class _22_括号生成Test {
@Test
  public void test(){
  assertEquals(Arrays.asList("((()))","(()())","(())()","()(())","()()()"),new _22_括号生成.Solution().generateParenthesis(3));
}
}