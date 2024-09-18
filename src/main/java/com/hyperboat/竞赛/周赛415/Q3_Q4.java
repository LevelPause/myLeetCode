package com.hyperboat.竞赛.周赛415;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
 * https://leetcode.cn/contest/weekly-contest-415/problems/minimum-number-of-valid-strings-to-form-target-i/
 * https://leetcode.cn/problems/minimum-number-of-valid-strings-to-form-target-ii/
 * */
public class Q3_Q4 {

  class Solution {

    public int minValidStrings(String[] words, String target) {
      return byAutoAC(words, target);
    }

    //前缀树方法, 在Q4会超时
    private int byTrie(String[] words, String target) {
      int n = target.length();
      char[] arr = target.toCharArray();
      Trie trie = new Trie();
      trie.insert(words);
      int[] dp = new int[n + 1];
      dp[n] = 0;
      Arrays.fill(dp, Integer.MAX_VALUE);
      for (int i = n - 1; i >= 0; i--) {
        Trie curr = trie;
        for (int j = i; j < n; j++) {
          int index = arr[j] - 'a';
          if (curr.children[index] == null) {
            break;
          }
          curr = curr.children[index];
          dp[i] = Math.min(dp[i], dp[j + 1] + 1);
        }
      }
      return dp[0] == Integer.MIN_VALUE ? -1 : dp[0];
    }

    //前缀树
    class Trie {

      Trie[] children;
      boolean isLeaf;

      public Trie() {
        children = new Trie[26];
      }

      public void insert(String[] words) {
        for (String word : words) {
          Trie curr = this;
          for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
              curr.children[i] = new Trie();
            }
            curr = curr.children[i];
          }
          curr.isLeaf = true;
        }
      }
    }

    //AC自动机方法, 适用于Q4
    private int byAutoAC(String[] words, String target) {
      AhoCorasick ac = new AhoCorasick();
      for (String w : words) {
        ac.put(w);
      }
      ac.buildFail();

      char[] t = target.toCharArray();
      int n = t.length;
      int[] f = new int[n + 1];
      Node cur = ac.root;
      for (int i = 0; i < n; i++) {
        // 如果没有匹配相当于移动到 fail 的 son[t[i]-'a']
        cur = cur.son[t[i] - 'a'];
        // 没有任何字符串的前缀与 target[..i] 的后缀匹配
        if (cur == ac.root) {
          return -1;
        }
        f[i + 1] = f[i + 1 - cur.len] + 1;
      }
      return f[n];
    }

    // 从根到 node 的字符串是某个（某些）words[i] 的前缀
    class Node {

      Node[] son = new Node[26];
      Node fail; // 当 cur.son[i] 不能匹配 target 中的某个字符时，cur.fail.son[i] 即为下一个待匹配节点（等于 root 则表示没有匹配）
      int len;

      Node(int len) {
        this.len = len;
      }
    }

    class AhoCorasick {

      Node root = new Node(0);

      void put(String s) {
        Node cur = root;
        for (char b : s.toCharArray()) {
          b -= 'a';
          if (cur.son[b] == null) {
            cur.son[b] = new Node(cur.len + 1);
          }
          cur = cur.son[b];
        }
      }

      void buildFail() {
        root.fail = root;
        Queue<Node> q = new ArrayDeque<>();
        for (int i = 0; i < root.son.length; i++) {
          Node son = root.son[i];
          if (son == null) {
            root.son[i] = root;
          } else {
            son.fail = root; // 第一层的失配指针，都指向根节点 ∅
            q.add(son);
          }
        }
        // BFS
        while (!q.isEmpty()) {
          Node cur = q.poll();
          for (int i = 0; i < 26; i++) {
            Node son = cur.son[i];
            if (son == null) {
              // 虚拟子节点 cur.son[i]，和 cur.fail.son[i] 是同一个
              // 方便失配时直接跳到下一个可能匹配的位置（但不一定是某个 words[k] 的最后一个字母）
              cur.son[i] = cur.fail.son[i];
              continue;
            }
            son.fail = cur.fail.son[i]; // 计算失配位置
            q.add(son);
          }
        }
      }
    }
  }
}
