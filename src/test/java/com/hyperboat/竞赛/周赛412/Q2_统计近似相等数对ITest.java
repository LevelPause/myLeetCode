package com.hyperboat.竞赛.周赛412;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q2_统计近似相等数对ITest {
@Test
  public void test(){
  assertEquals(2,new Q2_统计近似相等数对I.Solution().countPairs(new int[]{3,12,30,17,21}));
  assertEquals(12,new Q2_统计近似相等数对I.Solution().countPairs(new int[]{8,12,5,5,14,3,12,3,3,6,8,20,14,3,8}));
  assertEquals(27,new Q2_统计近似相等数对I.Solution().countPairs(new int[]{5,12,8,5,5,1,20,3,10,10,5,5,5,5,1}));

}
}