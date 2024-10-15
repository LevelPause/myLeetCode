package com.hyperboat.题单.位运算.其他;

/**
 * https://leetcode.cn/problems/find-the-duplicate-number/description/
 */
public class _287_寻找重复数 {

  //快慢指针找环
  class Solution {

    public int findDuplicate(int[] nums) {
      var slow = nums[0];
      var fast = nums[nums[0]];
      while (fast != slow) {
        slow = nums[slow];
        fast = nums[nums[fast]];
      }
      slow = 0;
      while (fast != slow) {
        fast = nums[fast];
        slow = nums[slow];
      }
      return slow;
    }
  }
}
