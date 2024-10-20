package com.hyperboat.normal.medium;


/*
988. 从叶结点开始的最小字符串
给定一颗根结点为root的二叉树，树中的每一个结点都有一个从0到25的值，分别代表字母'a'到'z'：值0 代表'a'，值1代表'b'，依此类推。
找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
（小贴士：字符串中任何较短的前缀在字典序上都是较小的：例如，在字典序上"ab" 比"aba"要小。叶结点是指没有子结点的结点。）

示例 1：
输入：[0,1,2,3,4,3,4]
输出："dba"
示例 2：
输入：[25,1,3,1,3,0,2]
输出："adz"
示例 3：
输入：[2,2,1,null,1,0,null,0]
输出："abc"*/
class LC988 {

  /*这里ans给定一个初始值‘~’，是为了让在后面的逻辑中第一次进行大小比较时，要比任意的字母字符串大*/
  String ans = "~";

  public String smallestFromLeaf(TreeNode root) {
    dfs(root, new StringBuilder());
    return ans;
  }

  /**
   * show 深度优先遍历
   *
   * @param root 根节点
   * @param sb   StringBuilder
   */
  private void dfs(TreeNode root, StringBuilder sb) {
    /*如果当前节点为空，则返回*/
    if (root == null) {
      return;
    }
    /*当前节点不为空，则添加当前节点值至字符串尾*/
    sb.append((char) ('a' + root.val));
    /*如果当前节点左右子节点都为空，则该节点为叶子节点*/
    if (root.left == null && root.right == null) {
      /*反转字符串，为了在下面与ans值比较*/
      sb.reverse();
      /*取值*/
      String S = sb.toString();
      /*二次反转，不影响其他分支结果*/
      sb.reverse();
      /*预期结果ans与当前值S比较大小，保证ans为最小的*/
      if (S.compareTo(ans) < 0) {
        ans = S;
      }
    }
    /*从左子节点dfs*/
    dfs(root.left, sb);
    /*从右子节点dfs*/
    dfs(root.right, sb);
    /*回溯*/
    sb.deleteCharAt(sb.length() - 1);

  }


  static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

}
