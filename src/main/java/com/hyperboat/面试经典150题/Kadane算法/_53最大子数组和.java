package com.hyperboat.面试经典150题.Kadane算法;

public class _53最大子数组和 {

  int[] nums;

  public int maxSubArray(int[] nums) {
    this.nums = nums;
    return divide(0, nums.length - 1).mSum;
//   return normal(nums);
//   return prefix(nums);
  }

  /*方法1*/
  //pre表示以当前i-1节点为结尾的连续数组和
  // 当num[i] 小于pre时, 就加入他们, 成为以i为结尾的连续数组和,即: pre+nums[i]
  // 当num[i]大于pre时，就舍弃pre，自己成为新的单独的连续数组和, 即: nums[i]
  public int normal(int[] nums) {
    int ans = nums[0];
    int pre = 0;
    for (int curr : nums) {
      pre = Math.max(pre + curr, curr);
      ans = Math.max(ans, pre);
    }
    return ans;
  }

  /*方法2*/
  //前缀和, 两个前缀和之差等于他们之间的子数组和(前置知识)
  public int prefix(int[] nums) {
    int preSum = 0, minPreSum = 0;
    int ans = Integer.MIN_VALUE;
    for (int curr : nums) {
      preSum += curr;
      ans = Math.max(ans, preSum - minPreSum);
      minPreSum = Math.min(preSum, minPreSum);
    }
    return ans;
  }

  /*方法3*/
  // 分治法
  public Info divide(int start, int end) {
    if (start == end) {
      return new Info(nums[start], nums[start], nums[start], nums[start]);
    }
    Info l = divide(start, (start + end) / 2);
    Info r = divide((start + end) / 2 + 1, end);
    return handle(l, r);
  }

  public Info handle(Info l, Info r) {
//    ------------     --------------
    int lSum = Math.max(l.lSum, r.lSum + l.iSum);
    int rSum = Math.max(r.rSum, r.iSum + l.rSum);
    int iSum = l.iSum + r.iSum;
    int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
    return new Info(lSum, rSum, iSum, mSum);
  }

  //Info 表示一段子数组的几个数组和的信息
  class Info {

    /*以左端点开始的最大连续数组和*/
    int lSum;
    /*以右端点开始的最大连续数组和*/
    int rSum;
    /*当前区间和*/
    int iSum;
    /*当前区间的最大连续子数组和*/
    int mSum;

    public Info(int lSum, int rSum, int iSum, int mSum) {
      this.lSum = lSum;
      this.rSum = rSum;
      this.iSum = iSum;
      this.mSum = mSum;
    }
  }
}
