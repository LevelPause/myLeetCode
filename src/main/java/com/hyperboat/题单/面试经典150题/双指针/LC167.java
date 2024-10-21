package com.hyperboat.题单.面试经典150题.双指针;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
class LC167 {

  public int[] twoSum(int[] numbers, int target) {
    int[] res = new int[2];
    int start = 0;
    int end = numbers.length - 1;
    while (start < end) {
      int sum = numbers[start] + numbers[end];
      if (sum == target) {
        res[0] = start + 1;
        res[1] = end + 1;
        break;
      } else if (sum < target) {
        start++;
      } else {
        end--;
      }
    }
    return res;
  }
}
