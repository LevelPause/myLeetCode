package com.hyperboat.题单.hot100.技巧;

/**
 * 287. 寻找重复数
 * <p>
 * https://leetcode.cn/problems/find-the-duplicate-number/description/
 */
class LC287 {

  public int findDuplicate(int[] nums) {
    return doublePointer(nums);
  }

  // 快慢指针 找环 O(n)
  private int doublePointer(int[] nums) {
    int slow = nums[0];
    int fast = nums[nums[0]];
    while (fast != slow) {
      fast = nums[nums[fast]];
      slow = nums[slow];
    }
    slow = 0;
    while (fast != slow) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return slow;
  }

  //二分 , 重复的那一半计数会多，依据这个划分 O(nlogn)
  private int divide(int[] nums) {
    int n = nums.length;
    int l = 0, r = n - 1;
    while (l <= r) {

      int m = (l + r) / 2;
      int count = 0;

      for (int num : nums) {
        if (num <= m) {
          count++;
        }
      }
      if (count > m) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    return l;
  }

}