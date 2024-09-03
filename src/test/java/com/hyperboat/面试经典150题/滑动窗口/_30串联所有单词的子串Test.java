package com.hyperboat.面试经典150题.滑动窗口;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.滑动窗口._30串联所有单词的子串;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class _30串联所有单词的子串Test {

  @Test
  void findSubstring() {
    List<Integer> res = new ArrayList<>();
    res.add(0);
    res.add(9);
    assertEquals(res,new _30串联所有单词的子串().findSubstring("barfoothefoobarman",new String[]{"foo","bar"}));
    List<Integer> res2 = new ArrayList<>();
    res2.add(8);
    assertEquals(res2, new _30串联所有单词的子串().findSubstring("wordgoodgoodgoodbestword",
        new String[]{"word", "good", "best", "good"}));
    List<Integer> res3 = new ArrayList<>();
//    res3.add(8);
    assertEquals(res3, new _30串联所有单词的子串().findSubstring("wordgoodgoodgoodbestword",
        new String[]{"word","good","best","word"}));
  }
}