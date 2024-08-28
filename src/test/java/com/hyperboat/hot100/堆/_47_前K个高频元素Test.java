package com.hyperboat.hot100.堆;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.hot100.堆._47_前K个高频元素.Solution;
import org.junit.jupiter.api.Test;

class _47_前K个高频元素Test {
@Test
  public void test(){
  assertArrayEquals(new int[]{1,2},new Solution().topKFrequent(new int[]{1,1,1,2,2,3},2));
}
}