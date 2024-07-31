package com.hyperboat.面试经典150题.Kadane算法;

public class _918环形子数组的最大和 {

  /*
   * 这题重点要理解最大连续子数组和成环后怎么算
   * 所以要分两种情况；
   * 1. 最大连续子数组没有成环, 那就按照53题常规求得
   * 2. 最大连续子数组成环, 那么 最大子数组和 = 数组总和 - 最小子数组和
   * 要想证明情况2中的等式可以用反证法：
   * 在最大子数组成环的情况下， 假设最大子数组和最小子数组中间有元素, 那么该元素不管大于0还是小于0都会归到其中一个数组中，
   * 因此两数组中间不可能有元素, 也即两者的并集为全集
   *
   * 在以上两种情况的第二种中有个特殊情况， 就是当元素全为负数时，使用【数组总和】-【最小子数组和】==0 也即最大子数组和为0，不符合要求，所以排除掉这种情况
   *
   * */
  public int maxSubarraySumCircular(int[] nums) {
    int currMaxSum = 0;
    int maxSum = nums[0];
    int minSum = 0;
    int currMinSum = 0;
    int totalSum = 0;
    for (int num : nums) {
      currMaxSum = Math.max(currMaxSum + num, num);
      currMinSum = Math.min(currMinSum + num, num);
      maxSum = Math.max(maxSum, currMaxSum);
      minSum = Math.min(minSum, currMinSum);
      totalSum += num;
    }
    System.out.println(maxSum);
    System.out.println(minSum);
    System.out.println(totalSum);
    return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum;
  }

  public static void main(String[] args) {
    System.out.println(new _918环形子数组的最大和().maxSubarraySumCircular(new int[]{-3, -2, -3}));
  }
}
