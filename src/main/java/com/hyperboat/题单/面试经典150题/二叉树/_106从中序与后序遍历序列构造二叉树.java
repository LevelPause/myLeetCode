package com.hyperboat.题单.面试经典150题.二叉树;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/?envType=study-plan-v2&envId=top-interview-150
 * Definition for a binary tree node.
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class _106从中序与后序遍历序列构造二叉树 {

  //  存放节点值到对应在postorder和inorder的映射 num2index.get(i)[0]是postorder, num2index.get(i)[1]是inorder
  Map<Integer, int[]> num2index;
  int[] inorder;
  int[] postorder;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    int n = inorder.length;
    this.inorder = inorder;
    this.postorder = postorder;
    num2index = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int[] postIndex = num2index.getOrDefault(postorder[i], new int[2]);
      postIndex[0] = i;
      num2index.put(postorder[i], postIndex);
      int[] inIndex = num2index.getOrDefault(inorder[i], new int[2]);
      inIndex[1] = i;
      num2index.put(inorder[i], inIndex);

    }
    TreeNode root = new TreeNode(postorder[n - 1]);
    dfs(root, 0, n - 1);
    return root;
  }

  // root是当前树, start 和end是当前树的覆盖索引范围(inorder)
  public TreeNode dfs(TreeNode root, int start, int end) {
//    获得当前树根在postorder的索引
    int postIndex = num2index.get(root.val)[0];
    //    获得当前树根在inorder的索引
    int inIndex = num2index.get(root.val)[1];
    TreeNode left = null;
    TreeNode right = null;
//    如果inorder中树根索引左边的有效范围还有元素的话，说明有左子树, 那么构造left子树
    if (inIndex - start > 0) {
      left = dfs(new TreeNode(postorder[postIndex - (end - inIndex + 1)]), start, inIndex - 1);
    }
    //    如果inorder中树根索引右边的有效范围还有元素的话，说明有右子树, 那么构造right子树
    if (end - inIndex > 0) {
      right = dfs(new TreeNode(postorder[postIndex - 1]), inIndex + 1, end);
    }
    root.left = left;
    root.right = right;
    return root;
  }

  class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
