package com.hyperboat.题单.面试经典150题.二叉树;


import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?envType=study-plan-v2&envId=top-interview-150
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
class _105从前序与中序遍历序列构造二叉树 {

  int[] preorder;
  int[] inorder;
  //  存放节点值到对应在preorder和inorder的映射 num2index.get(i)[0]是preorder, num2index.get(i)[1]是inorder
  Map<Integer, int[]> num2index;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int n = preorder.length;
    this.preorder = preorder;
    this.inorder = inorder;
    num2index = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int[] preIndex = num2index.getOrDefault(preorder[i], new int[2]);
      preIndex[0] = i;
      num2index.put(preorder[i], preIndex);
      int[] inIndex = num2index.getOrDefault(inorder[i], new int[2]);
      inIndex[1] = i;
      num2index.put(inorder[i], inIndex);
    }
    TreeNode root = new TreeNode(preorder[0]);
    dfs(root, 0, n - 1);
    return root;
  }

  // root是当前树, start 和end是当前树的覆盖索引范围(inorder)
  public TreeNode dfs(TreeNode root, int start, int end) {
    if (root == null) {
      return null;
    }
//    获得当前树根在preorder的索引
    int preIndex = num2index.get(root.val)[0];
    //    获得当前树根在inorder的索引
    int inIndex = num2index.get(root.val)[1];
    TreeNode left = null;
    TreeNode right = null;
//    如果inorder中树根索引左边的有效范围还有元素的话，说明有左子树, 那么构造left子树
    if (inIndex - start > 0) {
      left = dfs(new TreeNode(preorder[preIndex + 1]), start, inIndex - 1);
    }
    //    如果inorder中树根索引右边的有效范围还有元素的话，说明有右子树, 那么构造right子树
    if (end - inIndex > 0) {
      right = dfs(new TreeNode(preorder[preIndex + (inIndex - start + 1)]), inIndex + 1, end);
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
