package com.hyperboat.竞赛.周赛418;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hyperboat.竞赛.周赛418.Q2_移除可疑的方法.Solution;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class Q2_移除可疑的方法Test {

  @Test
  public void test() {
    Solution s = new Solution();
    assertEquals(Arrays.asList(0, 1, 2, 3),
        s.remainingMethods(4, 1, new int[][]{{1, 2}, {0, 1}, {3, 2}}));
  }

  @Test
  public void test1() {
    Solution s = new Solution();
    assertEquals(Arrays.asList(3, 4),
        s.remainingMethods(5, 0, new int[][]{{1, 2}, {0, 2}, {0, 1}, {3, 4}}));
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    assertEquals(Collections.emptyList(),
        s.remainingMethods(3, 2, new int[][]{{1, 2}, {0, 1}, {2, 0}}));
  }
}