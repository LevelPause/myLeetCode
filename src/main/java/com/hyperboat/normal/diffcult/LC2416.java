package com.hyperboat.normal.diffcult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangweigang
 * @date 2023年10月18日 4:43
 */
public class LC2416 {

  //暴力遍历，不出意外的超时了
  public int[] sumPrefixScores1(String[] words) {
    Map<String, Integer> prefixs = new HashMap<>();
    int[] res = new int[words.length];
    //把所有前缀和次数放入map
    for (String word : words) {
      for (int i = 0; i < word.length(); i++) {
        String currWord = word.substring(0, i + 1);
        prefixs.merge(currWord, 1, Integer::sum);
      }
    }
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      for (int j = 0; j < word.length(); j++) {
        String prefixWord = word.substring(0, j + 1);
        res[i] += prefixs.get(prefixWord);
      }
    }
    return res;
  }

  public int[] sumPrefixScores(String[] words) {
    int[] res = new int[words.length];
    Node root = new Node();

    //先确认分数
    for (String word : words) {
      Node curr = root;
      for (char c : word.toCharArray()) {
        if (curr.next[c - 'a'] == null) {
          curr.next[c - 'a'] = new Node();
        }
        curr = curr.next[c - 'a'];
        curr.score++;
      }
    }

    for (int i = 0; i < words.length; i++) {
      Node curr = root;
      for (char c : words[i].toCharArray()) {
        res[i] += curr.next[c - 'a'].score;
        curr = curr.next[c - 'a'];
      }
    }

    return res;
  }


  public static class Node {

    Node[] next;
    int score;

    public Node() {
      next = new Node[26];
    }
  }
}
