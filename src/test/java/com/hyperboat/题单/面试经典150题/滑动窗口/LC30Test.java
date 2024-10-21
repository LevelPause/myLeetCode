package com.hyperboat.题单.面试经典150题.滑动窗口;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LC30Test {

  @Test
  void findSubstring() {
    List<Integer> res = new ArrayList<>();
    res.add(0);
    res.add(9);
    assertEquals(res,new LC30().findSubstring("barfoothefoobarman",new String[]{"foo","bar"}));
    List<Integer> res2 = new ArrayList<>();
    res2.add(8);
    assertEquals(res2, new LC30().findSubstring("wordgoodgoodgoodbestword",
        new String[]{"word", "good", "best", "good"}));
    List<Integer> res3 = new ArrayList<>();
//    res3.add(8);
    assertEquals(res3, new LC30().findSubstring("wordgoodgoodgoodbestword",
        new String[]{"word","good","best","word"}));
  }
}