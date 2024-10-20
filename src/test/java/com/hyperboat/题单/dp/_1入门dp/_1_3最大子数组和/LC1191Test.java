package com.hyperboat.题单.dp._1入门dp._1_3最大子数组和;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LC1191Test {

  @Test
  public void test() {
    assertEquals(20,
        new LC1191().kConcatenationMaxSum(new int[]{-5, -2, 0, 0, 3, 9, -2, -5, 4}, 5));
//    {lSum=5, iSum=2, mSum=12, rSum=9}{lSum=5, iSum=2, mSum=12, rSum=9}{lSum=5, iSum=2, mSum=12, rSum=9}
  }
}