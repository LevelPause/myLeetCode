package com.hyperboat.面试经典150题;

/**
 * @author zhangweigang
 * @date 2023年10月18日 11:38
 */
public class LC80删除有序数组中的重复项II {

  //优化写法, 有k的通解， 在此题中k==2
  public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    }
    int left = 2, right = 2;
    int tail = nums.length;
    while (right < tail) {
      if (nums[left - 2] != nums[right]) {
        nums[left++] = nums[right];
      }
      right++;
    }
    return left;
  }

  //在原有基础上增加两次重复的flag,有标志时慢指针left同样会赋值和移动, 遇到不重复的元素时会将flag重置
  public int removeDuplicates2(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }
    boolean doubleFlag = true;
    int left = 0, right = 1;
    int tail = nums.length;
    while (right < tail) {
      if (nums[left] != nums[right]) {
        nums[left + 1] = nums[right];
        left++;
        doubleFlag = true;
      } else {
        if (doubleFlag) {
          nums[left + 1] = nums[right];
          left++;
          doubleFlag = false;
        }
      }
      right++;
    }
    return left + 1;
  }
}
