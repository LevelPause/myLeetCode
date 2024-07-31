package com.hyperboat.面试经典150题.分治;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hyperboat.面试经典150题.分治._427建立四叉树.Node;
import org.junit.jupiter.api.Test;

class _427建立四叉树Test {

  @Test
  void construct() {
    int[][] grid = {{0, 1}, {1, 0}};
//    01234567
    Node root = new Node(true, false,
        new Node(false, true),
        new Node(true, true),
        new Node(true, true),
        new Node(false, true));

    assertEquals(root, new _427建立四叉树().construct(grid));
  }
}