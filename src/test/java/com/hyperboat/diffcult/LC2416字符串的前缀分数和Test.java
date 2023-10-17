package com.hyperboat.diffcult;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月18日 4:44
 */
class LC2416字符串的前缀分数和Test {

  @Test
  void sumPrefixScores() {
    System.out.println(
        Arrays
            .toString(new LC2416字符串的前缀分数和().sumPrefixScores(new String[]{"abc", "ab", "bc", "b"})));
  }
}