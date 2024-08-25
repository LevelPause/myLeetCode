package com.hyperboat.竞赛.周赛412;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q4_统计近似相等数对2Test {
  @Test
  public void test(){
    assertEquals(4,new Q4_统计近似相等数对2.Solution().countPairs(new int[]{1023,2310,2130,213}));
    assertEquals(23,new Q4_统计近似相等数对2.Solution().countPairs(new int[]{10,3,10,10,1,19,3,1,10,10,19,13}));
    assertEquals(6,new Q4_统计近似相等数对2.Solution().countPairs(new int[]{15,61,16,6,61,61}));
  }
}