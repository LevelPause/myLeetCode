package com.hyperboat.面试经典150题.区间;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class _228汇总区间Test {

  @Test
  void summaryRanges() {
    ArrayList<Object> expected = new ArrayList<>();
    expected.add("0");
    expected.add("2->4");
    expected.add("6");
    expected.add("8->9");
    assertEquals(expected,new _228汇总区间().summaryRanges(new int[]{0,2,3,4,6,8,9}));
  }
}