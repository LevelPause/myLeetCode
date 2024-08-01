package com.hyperboat.面试经典150题.堆;

/*
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _215数组中的第K个最大元素 {

  public int findKthLargest(int[] nums, int k) {
    int[] bucket = new int[20001];
    for (int num : nums) {
      bucket[num + 10000]++;
    }
    for (int i = bucket.length - 1; i >= 0; i--) {
      k -= bucket[i];
      if (k <= 0) {
        return i - 10000;
      }
    }
    return 0;
  }
}
