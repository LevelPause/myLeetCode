package com.hyperboat.题单.位运算.试填法;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/maximum-strong-pair-xor-ii/description/
 * */
class _2935_找出强数对的最大异或值II {

  class Node {

    Node[] children = new Node[2];
    int cnt; // 子树大小
  }

  class Trie {

    private static final int HIGH_BIT = 19;
    private Node root = new Node();

    // 添加 val
    public void insert(int val) {
      Node cur = root;
      for (int i = HIGH_BIT; i >= 0; i--) {
        int bit = (val >> i) & 1;
        if (cur.children[bit] == null) {
          cur.children[bit] = new Node();
        }
        cur = cur.children[bit];
        cur.cnt++; // 维护子树大小
      }
    }

    // 删除 val，但不删除节点
    // 要求 val 必须在 trie 中
    public void remove(int val) {
      Node cur = root;
      for (int i = HIGH_BIT; i >= 0; i--) {
        cur = cur.children[(val >> i) & 1];
        cur.cnt--; // 维护子树大小
      }
    }

    // 返回 val 与 trie 中一个元素的最大异或和
    // 要求 trie 不能为空
    public int maxXor(int val) {
      Node cur = root;
      int ans = 0;
      for (int i = HIGH_BIT; i >= 0; i--) {
        int bit = (val >> i) & 1;
        // 如果 cur.children[bit^1].cnt == 0，视作空节点
        if (cur.children[bit ^ 1] != null && cur.children[bit ^ 1].cnt > 0) {
          ans |= 1 << i;
          bit ^= 1;
        }
        cur = cur.children[bit];
      }
      return ans;
    }
  }

  class Solution {

    public int maximumStrongPairXor(int[] nums) {
      Arrays.sort(nums);
      Trie t = new Trie();
      int ans = 0, left = 0;
      for (int y : nums) {
        t.insert(y);
        while (nums[left] * 2 < y) {
          t.remove(nums[left++]);
        }
        ans = Math.max(ans, t.maxXor(y));
      }
      return ans;
    }
  }
}
