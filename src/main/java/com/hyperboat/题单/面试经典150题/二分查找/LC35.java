package com.hyperboat.题单.面试经典150题.二分查找;

class LC35 {


  public int searchInsert(int[] nums, int target) {
    int l = 0;
    int r = nums.length;
    while (l < r) {
      int mid = (l + r) / 2;
      if (target == nums[mid]) {
        return mid;
      }
      if (target < nums[mid]) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return r;
  }

}
