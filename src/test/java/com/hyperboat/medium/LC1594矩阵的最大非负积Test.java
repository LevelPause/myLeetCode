package com.hyperboat.medium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月18日 5:48
 */
class _1594矩阵的最大非负积Test {

  @Test
  void maxProductPath() {
    assertEquals(new _1594矩阵的最大非负积().maxProductPath(new int[][]{{1, -1, 2, 1, -1, 0, 0, 4, 3, 2, 0, -2, -2},
        {-2, 3, 3, -1, -1, 0, 0, -2, 4, -3, 3, 0, 0},
        {-4, -1, -1, -2, 2, -1, -2, -2, 0, 3, -1, -4, 1},
        {-3, 4, -3, 0, -3, 1, -3, 1, 4, 4, -4, -4, -2},
        {3, -3, 1, 0, -1, -4, -4, -4, 3, 2, 2, 3, 3},
        {2, -1, -1, -4, -3, -3, 4, 2, 3, 4, 4, -4, 0},
        {4, -1, 2, -3, -1, -1, -3, -4, 4, 4, 4, -3, -1},
        {-3, -4, 4, -2, -1, 2, 3, -1, 2, 3, 4, 4, -4},
        {-3, -1, -2, 1, 1, -1, -3, -4, -3, 1, -3, 3, -4},
        {2, 4, 4, 4, -3, -3, 1, -1, 3, 4, -1, 1, 4},
        {2, -2, 0, 4, -1, 0, -2, 4, -4, 0, 0, 2, -3},
        {1, 1, -3, 0, -4, -4, -4, -4, 0, -1, -4, -1, 0},
        {3, -1, -3, -3, -3, -2, -1, 4, -1, -2, 4, 2, 3}}),459630706);
    assertEquals(new _1594矩阵的最大非负积().maxProductPath(new int[][]{{-1,-2,-3},{-2,-3,-3},{-3,-3,-2}}),-1);
  }
}