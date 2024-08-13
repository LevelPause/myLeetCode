package com.hyperboat.hot100.双指针;

public class _42_接雨水 {

  // 一个柱子头顶上能蓄水的条件是两边都有比它还高的柱子
//  那这个柱子蓄水量=min(height[maxL],height[maxR])-height
//  依次遍历累加每个柱子的蓄水量即可(最左边和最右边的柱子无法蓄水，跳过即可)
  public int trap(int[] height) {
    return lAndR(height);
  }

  public int normal(int[] height) {
    int n = height.length;
    if (n <= 2) {
      return 0;
    }
    int[] maxL = new int[n];
    maxL[0] = height[0];
    int ans = 0;

    for (int i = 1; i < n; i++) {
      maxL[i] = Math.max(maxL[i - 1], height[i]);
    }
    int maxR = height[n - 1];
    for (int i = n - 2; i > 0; i--) {
      maxR = Math.max(maxR, height[i]);
      int minH = Math.min(maxR, maxL[i]);
      if (minH > height[i]) {
        ans += minH - height[i];
      }
    }
    return ans;

  }

  public int lAndR(int[] height) {
    int n = height.length;
    if (n <= 2) {
      return 0;
    }
    int ans = 0;
    int l = 0;
    int r = n - 1;
    int maxL = 0;
    int maxR = 0;

    while (l < r) {
      maxL = Math.max(maxL, height[l]);
      maxR = Math.max(maxR, height[r]);
      if (maxL < maxR) {
        ans += maxL - height[l++];
      } else {
        ans += maxR - height[r--];
      }
    }

    return ans;
  }
}
