package com.hyperboat.题单.面试经典150题.字典树;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LC212Test {

  @Test
  void findWords() {
    char[][] board = {
        {'o', 'a', 'a', 'n'},
        {'e', 't', 'a', 'e'},
        {'i', 'h', 'k', 'r'},
        {'i', 'f', 'l', 'v'}};
    String[] words = {"oath", "pea", "eat", "rain"};
    List<Object> expected = Arrays.asList("oath", "eat");
    assertEquals(expected, new LC212().findWords(board, words));
  }

  @Test
  void test() {
    char[][] board = {
        {'a', 'a', 'b'}, {'a', 'a', 'b'}};
    String[] words = {"aaaaa"};
    List<Object> expected = new ArrayList<>();
    assertEquals(expected, new LC212().findWords(board, words));
  }

  @Test
  void test2() {
    char[][] board = {
        {'a', 'b', 'e'}, {'b', 'c', 'd'}};
    String[] words = {"abcdeb"};
    List<Object> expected = Arrays.asList("abcdeb");
    assertEquals(expected, new LC212().findWords(board, words));
  }
}