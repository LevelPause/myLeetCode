package com.hyperboat.面试经典150题.图的广度优先搜索;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class _127单词接龙Test {

  String starWord = "hbo";
  String endWord = "qbx";
  List<String> wordList = Arrays.asList("abo", "hco", "hbw", "ado", "abq", "hcd", "hcj", "hww",
      "qbq", "qby", "qbz", "qbx", "qbw");

  @Test
  void doubleBfs() {
    assertEquals(4, new _127单词接龙().doubleBfs(starWord, endWord, wordList));
  }

  @Test
  void bfs() {
    assertEquals(4, new _127单词接龙().bfs(starWord, endWord, wordList));
  }
}