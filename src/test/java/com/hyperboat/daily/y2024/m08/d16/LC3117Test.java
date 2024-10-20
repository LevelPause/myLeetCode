package com.hyperboat.daily.y2024.m08.d16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LC3117Test {

  @Test
  public void test() {
    int[] nums = new int[]{1, 4, 3, 3, 2};
    int[] adnValues = new int[]{0, 3, 3, 2};
    assertEquals(12, new LC3117().minimumValueSum(nums, adnValues));
  }
  @Test
  public void test1() {
    int[] nums = new int[]{4,4};
    int[] adnValues = new int[]{4};
    assertEquals(4, new LC3117().minimumValueSum(nums, adnValues));
  }
}