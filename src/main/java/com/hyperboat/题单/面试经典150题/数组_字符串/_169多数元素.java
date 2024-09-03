package com.hyperboat.题单.面试经典150题.数组_字符串;

import java.util.Arrays;

/**
 * @author zhangweigang
 * @date 2023年10月18日 12:03
 */
public class _169多数元素 {

  //投票算法  很有意思，用来找超过总数一半的数
  public int majorityElement(int[] nums) {
    int currNum = nums[0];
    int count = 0;
    for (int num : nums) {
      if (count == 0) {
        currNum = num;
      }
      count += currNum == num ? 1 : -1;
    }
    return currNum;
  }

  //也可用笨方法轻松实现
  public int majorityElement2(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }
}
