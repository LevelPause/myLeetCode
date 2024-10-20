package com.hyperboat.题单.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月18日 12:46
 */
class _189轮转数组 {


  //进阶解法， 利用了翻转再翻转后的每组整体顺序不变的特性
  // 第一次全翻转数组，数组变为逆序，第二次将前k个翻转，得到会被挤到头部的那一坨，第三次将剩余的翻转对应的是会后移k%n步的那一坨
  public void rotate(int[] nums, int k) {
    int n = nums.length;
    reverse(nums, 0, n - 1);
    reverse(nums, 0, k % n - 1);
    reverse(nums, k % n, n - 1);
  }

  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      nums[start] ^= nums[end];
      nums[end] ^= nums[start];
      nums[start] ^= nums[end];
      start++;
      end--;
    }
  }


  //普通方法  复制数组到新数组并位移k个位置，然后再复制回去
  public void rotate1(int[] nums, int k) {
    int n = nums.length;
    int[] newNums = new int[n];
    for (int i = 0; i < n; i++) {
      newNums[(i + k) % n] = nums[i];
    }
    System.arraycopy(newNums, 0, nums, 0, n);
  }
}
