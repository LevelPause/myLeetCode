package com.hyperboat.题单.面试经典150题.分治;
/*
https://leetcode.cn/problems/construct-quad-tree/?envType=study-plan-v2&envId=top-interview-150
*/

import java.util.Objects;

class LC427 {

  int[][] grid;

  public Node construct(int[][] grid) {
    this.grid = grid;
    return divide(0, grid.length, 0, grid[0].length);
  }

  public Node divide(int iL, int iR, int jL, int jR) {
    boolean same = true;
    for (int p = iL; same && p < iR; p++) {
      for (int k = jL; k < jR; k++) {
        if (grid[iL][jL] != grid[p][k]) {
          same = false;
          break;
        }
      }
    }
    if (same) {
      return new Node(grid[iL][jL] == 1, true);
    }
    Node root = new Node(true, false);
    int midI = (iL + iR) / 2;
    int midJ = (jL + jR) / 2;
    root.topLeft = divide(iL, midI, jL, midJ);
    root.topRight = divide(iL, midI, midJ, jR);
    root.bottomLeft = divide(midI, iR, jL, midJ);
    root.bottomRight = divide(midI, iR, midJ, jR);
    return root;
  }

  public static class Node {

    @Override
    public String toString() {
      return "Node{" +
          "val=" + val +
          ", isLeaf=" + isLeaf +
          ", topLeft=" + topLeft +
          ", topRight=" + topRight +
          ", bottomLeft=" + bottomLeft +
          ", bottomRight=" + bottomRight +
          '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Node node = (Node) o;
      return val == node.val && isLeaf == node.isLeaf;
    }

    @Override
    public int hashCode() {
      return Objects.hash(val, isLeaf);
    }

    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
      this.val = false;
      this.isLeaf = false;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft,
        Node bottomRight) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = topLeft;
      this.topRight = topRight;
      this.bottomLeft = bottomLeft;
      this.bottomRight = bottomRight;
    }
  }
}