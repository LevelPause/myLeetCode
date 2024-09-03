package com.hyperboat.面试经典150题.多维动态规划;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.多维动态规划._64最小路径和;
import org.junit.jupiter.api.Test;

class _64最小路径和Test {

  @Test
  void minPathSum() {
    int [][] grid = new int[][]{
        {1,2,3},
        {4,5,6}};
    assertEquals(12,new _64最小路径和().minPathSum(grid));
  }
}