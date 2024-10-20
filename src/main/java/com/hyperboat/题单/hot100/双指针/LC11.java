package com.hyperboat.题单.hot100.双指针;

/**
 * 11. 盛最多水的容器
 * <p>
 * https://leetcode.cn/problems/container-with-most-water/description/
 */
class LC11 {

  public int maxArea(int[] height) {
    int n = height.length;
    int l = 0;
    int r = n - 1;
    int ans = 0;
    while (l < r) {
      ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }
    return ans;
  }
}
