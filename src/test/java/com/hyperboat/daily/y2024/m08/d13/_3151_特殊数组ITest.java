package com.hyperboat.daily.y2024.m08.d13;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.daily.y2024.m08.d13._3151_特殊数组I.Solution;
import org.junit.jupiter.api.Test;

public class _3151_特殊数组ITest {

  @Test
  void isArraySpecial() {
    assertFalse(new Solution().isArraySpecial(new int[]{1, 2, 3, 4, 5, 6, 6}));
  }
}