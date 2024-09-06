package com.hyperboat.题单.dp._1入门dp._1_3最大子数组和;

public class _1191_K次串联后最大子数组之和 {

  static class Solution {

    public int kConcatenationMaxSum(int[] arr, int k) {
      long ans;
      int mod = (int) 1e9 + 7;
      Node node = divide(arr, 0, arr.length - 1);
      if (k == 1) {
        ans = Math.max(node.mSum, 0);
      } else {
        long twoMax = Math.max((long) node.rSum + node.lSum, node.mSum) % mod;
        long restMax = (long) (k - 2) * (Math.max(node.iSum, 0)) % mod;
        long kMax = (twoMax + restMax) % mod;
        ans = Math.max(kMax, 0);
      }
      return (int) ans;

    }

    private Node divide(int[] arr, int l, int r) {
      if (l == r) {
        return new Node(arr[l], arr[l], arr[l], arr[l]);
      }
      int m = (l + r) / 2;
      Node lNode = divide(arr, l, m);
      Node rNode = divide(arr, m + 1, r);
      int lSum = Math.max(lNode.lSum, rNode.lSum + lNode.iSum);
      int rSum = Math.max(rNode.rSum, rNode.iSum + lNode.rSum);
      int iSum = rNode.iSum + lNode.iSum;
      int mSum = Math.max(lNode.mSum, Math.max(rNode.mSum, lNode.rSum + rNode.lSum));
      return new Node(lSum, rSum, iSum, mSum);
    }

    class Node {

      int lSum;
      int rSum;
      int iSum;
      int mSum;

      @Override
      public String toString() {
        return "Node{" +
            "lSum=" + lSum +
            ", rSum=" + rSum +
            ", iSum=" + iSum +
            ", mSum=" + mSum +
            '}';
      }

      public Node(int lSum, int rSum, int iSum, int mSum) {
        this.lSum = lSum;
        this.rSum = rSum;
        this.iSum = iSum;
        this.mSum = mSum;
      }
    }
  }
}
