package com.hyperboat.面试经典150题.双指针;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
public class LC167两数之和II输入有序数组 {

  public int[] twoSum(int[] numbers, int target) {
    int[] res = new int[2];
    int start = 0;
    int end = numbers.length - 1;
    while (start < end) {
      int sum = numbers[start] + numbers[end];
      if (sum == target) {
        res[0] = start;
        res[1] = end;
        break;
      } else if (sum < target) {
        start++;
      } else {
        end--;
      }
    }
    return res;
  }

  public int[] twoSum1(int[] numbers, int target) {
    int[] res = new int[2];
    Map<Integer, Integer> nums = new HashMap<>();
    for (int i = 0; i < numbers.length; i++) {
      nums.put(numbers[i], i);
    }
    for (int i = 0; i < numbers.length; i++) {
      Integer index = nums.get(target - numbers[i]);
      if (index != null && index > i) {
        res[0] = i;
        res[1] = index;
      }
    }
    return res;
  }
}
