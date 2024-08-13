package com.hyperboat.hot100.普通数组;

public class _53_最大子数组和 {

  public int maxSubArray(int[] nums) {
    return dp(nums);
  }

  public int dp(int[] nums) {
    int currSum = Integer.MIN_VALUE;
    int ans = nums[0];
    for (int num : nums) {
      currSum = Math.max(0, currSum) + num;
      ans = Math.max(ans, currSum);
    }
    return ans;
  }

  public Node divide(int l, int r, int[] nums) {
    if (l == r) {
      return new Node(nums[l], nums[l], nums[l], nums[l]);
    }
    int m = (l + r) >> 1;
    Node lNode = divide(l, m, nums);
    Node rNode = divide(m + 1, r, nums);
    int lSum = Math.max(lNode.lSum, lNode.iSum + rNode.lSum);
    int rSum = Math.max(rNode.rSum, rNode.iSum + lNode.rSum);
    int iSum = lNode.iSum + rNode.iSum;
    int mSum = Math.max(Math.max(lNode.mSum, rNode.mSum), lNode.rSum + rNode.lSum);
    return new Node(lSum, rSum, iSum, mSum);
  }

  class Node {

    /*以左端点为头的最大和*/
    int lSum;
    /*以右端点为头的最大和*/
    int rSum;
    /*数组总和*/
    int iSum;
    /*数组最大和*/
    int mSum;

    public Node(int lSum, int rSum, int iSum, int mSum) {
      this.lSum = lSum;
      this.rSum = rSum;
      this.iSum = iSum;
      this.mSum = mSum;
    }
  }
}
