package com.hyperboat.normal.medium;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.normal.medium.LC1105;
import org.junit.jupiter.api.Test;

class LC1105Test {

  @Test
  void minHeightShelves() {
    assertEquals(6,new LC1105().minHeightShelves(new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}},4));
  }
}