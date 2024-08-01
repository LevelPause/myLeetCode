package com.hyperboat.面试经典150题.二分查找;

public class _33搜索旋转排序数组 {

  public int search(int[] nums, int target) {
    int n = nums.length;
    //记录最小值的下标
    int min = 0;
    int l = 1, r = n - 1;
    //第一个二分用于寻找原有序数组的开头
    while (l <= r) {
      int mid = (l + r) / 2;
      if (nums[mid] > nums[0]) {
        l = mid + 1;
      } else {
        min = mid;
        r = mid - 1;
      }
    }
    l = min;
    r = l + n - 1;
    //第二个二分用于寻找target
    // 这里定义的l和r相当于把原来翻转到前面的数组拼接到后面来, 然后通过取余来获得真实的下标
    while (l <= r) {
      int mid = (l + r) / 2;
      int index = mid % n;
      if (nums[index] == target) {
        return index;
      } else if (target < nums[index]) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return -1;
  }
}
