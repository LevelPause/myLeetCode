package com.hyperboat.面试经典150题.矩阵;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hyperboat.题单.面试经典150题.矩阵._54螺旋矩阵;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class _54螺旋矩阵Test {

  @Test
  void spiralOrder() {
    List<Object> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(8);
    list.add(12);
    list.add(11);
    list.add(10);
    list.add(9);
    list.add(5);
    list.add(6);
    list.add(7);
    int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    assertEquals(list, new _54螺旋矩阵().spiralOrder(matrix));
  }
}