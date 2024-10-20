package com.hyperboat.题单.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月18日 11:12
 */
class _26删除有序数组中的重复项 {

  //快慢双指针
  public int removeDuplicates(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }
    int left = 0, right = 1;
    int tail = nums.length;
    while (right < tail) {
      if (nums[left] != nums[right]) {
        nums[left + 1] = nums[right];
        left++;
      }
      right++;
    }
    return left + 1;
  }
}
