package com.hyperboat.hot100.双指针;

public class _11_盛最多水的容器 {

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
