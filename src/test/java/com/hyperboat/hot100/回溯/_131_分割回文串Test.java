package com.hyperboat.hot100.回溯;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hyperboat.题单.hot100.回溯._131_分割回文串;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class _131_分割回文串Test {

  @Test
  public void test() {
    assertEquals(Arrays.asList(Arrays.asList("aa", "b"), Arrays.asList("a", "a", "b")),
        new _131_分割回文串.Solution().partition("aab"));
  }
}