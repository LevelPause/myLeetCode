package com.hyperboat.normal.tobeclassified.词典中最长的单词;


/**
 * @author hyperboat
 * @date 2022年03月17日 3:01
 * <p>
 * 给出一个字符串数组words 组成的一本英语词典。返回words 中最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 * <p>
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 */
public class Solution {

  public String longestWord(String[] words) {
    String ans = "";
    Trie trie = new Trie();
    for (String word : words) {
      trie.insert(word);
    }

    for (String word : words) {
      if (trie.search(word)) {
        if (word.length() > ans.length() || (word.length() == ans.length()
            && word.compareTo(ans) < 0)) {
          ans = word;
        }
      }
    }
    return ans;
  }

  static class Trie {

    Node root;

    public Trie() {
      root = new Node();
    }

    public void insert(String word) {
      root.insert(word);
    }

    public boolean search(String word) {
      return root.search(word);
    }

    static class Node {

      Node[] next;
      boolean isLeaf;

      public Node() {
        next = new Node[26];
      }

      public void insert(String word) {
        Node item = this;
        for (char ch : word.toCharArray()) {
          int idx = ch - 'a';
          if (item.next[idx] == null) {
            item.next[idx] = new Node();
          }
          item = item.next[idx];
        }
        item.isLeaf = true;
      }

      public boolean search(String word) {
        Node item = this;
        for (char ch : word.toCharArray()) {
          int idx = ch - 'a';
          if (item.next[idx] == null || !item.next[idx].isLeaf) {
            return false;
          }
          item = item.next[idx];
        }
        return item != null && item.isLeaf;
      }
    }
  }
}
