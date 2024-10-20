package com.hyperboat.normal.diffcult;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月18日 4:44
 */
public class LC2416Test {

  @Test
  void sumPrefixScores() {
    System.out.println(
        Arrays
            .toString(new LC2416().sumPrefixScores(new String[]{"abc", "ab", "bc", "b"})));
  }
}