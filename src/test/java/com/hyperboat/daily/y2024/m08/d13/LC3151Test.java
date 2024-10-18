package com.hyperboat.daily.y2024.m08.d13;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.daily.y2024.m08.d13.LC3151.Solution;
import org.junit.jupiter.api.Test;

public class LC3151Test {

  @Test
  void isArraySpecial() {
    assertFalse(new Solution().isArraySpecial(new int[]{1, 2, 3, 4, 5, 6, 6}));
  }
}