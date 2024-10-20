package com.hyperboat.题单.hot100.双指针;

/**
 * 283. 移动零
 * <p>
 * https://leetcode.cn/problems/move-zeroes/description/
 */
class LC283 {

  public void moveZeroes(int[] nums) {
    m2(nums);
  }

  //双指针, 左指针指向筛选后的序列尾部, 右指针指向待筛选的头部, 左右指针之间全是0
  //右指针遇到非0的，就和左指针交换，左指针向右移一步
  public void m2(int[] nums) {
    int n = nums.length;
    int l = 0, r = 0;
    while (r < n) {
      if (nums[r] != 0) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
        l++;
      }
      r++;
    }
  }

  //  计数0 遇到0则计数器+1，遇到非0的则将数向左移计数器的步数, 同时将当前置0
  public void m1(int[] nums) {
    int n = nums.length;
    int l = 0;
    int r = n - 1;
    while (r >= 0 && nums[r] == 0) {
      r--;
    }
    while (l < n && nums[l] != 0) {
      l++;
    }
    int zeroCount = 0;
    for (int i = l; i <= r; i++) {
      if (nums[l] == 0) {
        zeroCount++;
      } else {
        nums[i - zeroCount] = nums[i];
        nums[i] = 0;
      }
    }

  }
}
