package com.hyperboat.题单.面试经典150题.数组_字符串;

import java.util.Arrays;

/**
 * @author zhangweigang
 * @date 2023年10月18日 10:24
 */
public class _27移除元素 {

  /*是个很经典的双指针问题, 右指针指向当前要处理的元素，左指针指向下一个要赋值的位置*/
  public int removeElement(int[] nums, int val) {

    int index = 0;
    int tail = nums.length;
    while (index < tail) {
      if (nums[index] == val) {
        nums[index] = nums[tail - 1];
        tail--;
      } else {
        index++;
      }
    }
    return index;
  }
}
