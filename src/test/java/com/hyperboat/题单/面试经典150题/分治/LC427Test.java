package com.hyperboat.题单.面试经典150题.分治;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hyperboat.题单.面试经典150题.分治.LC427.Node;
import org.junit.jupiter.api.Test;

class LC427Test {

  @Test
  void construct() {
    int[][] grid = {{0, 1}, {1, 0}};
//    01234567
    Node root = new Node(true, false,
        new Node(false, true),
        new Node(true, true),
        new Node(true, true),
        new Node(false, true));

    assertEquals(root, new LC427().construct(grid));
  }
}