package com.hyperboat.daily.y2024.m08.d08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LC3131Test {

  @Test
  void addedInteger() {
    int[] nums1 = new int[]{2,1,6,5,1,10,5};
    int[] nums2 = new int[]{246,250,251,250,247,246,255};

    assertEquals(245,new LC3131().addedInteger(nums1,nums2));
  }
}