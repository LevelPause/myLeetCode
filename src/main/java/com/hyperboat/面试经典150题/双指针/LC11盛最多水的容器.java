package com.hyperboat.面试经典150题.双指针;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
public class LC11盛最多水的容器 {

  //双指针, 无需多言, 注意移动指针的条件即可
  public int maxArea(int[] height) {
    int start = 0;
    int end = height.length - 1;
    int res = 0;
    while (start < end) {
      res = Math.max(res, Math.min(height[start], height[end]) * (end - start));
      if (height[start] < height[end]) {
        start++;
      } else {
        end--;
      }
    }
    return res;
  }
}
