package com.hyperboat.题单.程序员面试金典.树与图;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.cn/problems/list-of-depth-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
public class _04_03特定深度节点链表 {

  public ListNode[] listOfDepth(TreeNode tree) {
    if (tree == null) {
      return new ListNode[0];
    }
    List<ListNode> res = new ArrayList<>();
    Deque<TreeNode> qu = new ArrayDeque<>();
    qu.offerLast(tree);
    while (!qu.isEmpty()) {
      int size = qu.size();
      ListNode dummy = new ListNode(-1);
      ListNode curr = dummy;
      for (int i = 0; i < size; i++) {
        TreeNode poll = qu.pollFirst();
        curr.next = new ListNode(poll.val);
        curr = curr.next;
        if (poll.left != null) {
          qu.offerLast(poll.left);
        }
        if (poll.right != null) {
          qu.offerLast(poll.right);
        }
      }
      res.add(dummy.next);
    }
    return res.toArray(new ListNode[0]);
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
