package com.hyperboat.题单.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月21日
 */
public class _42接雨水 {

  //小总结一下, 做此类的题一定要记住分解, 类似于分治法的思想, 在此题求面积的时候按列来求面积,计算每一列的蓄水面积, 最后再累加
  //此题按行求面积时会超时, 不适用
  public int trap(int[] height) {
    int n = height.length;
    if (n < 3) {
      return 0;
    }
    int res = 0;
    int[] maxLeft = new int[n];
    maxLeft[0] = height[0];
    for (int i = 1; i < n; i++) {
      maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
    }
    int maxRight = height[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      maxRight = Math.max(maxRight, height[i]);
      int tempHeight = Math.min(maxRight, maxLeft[i]);
      res += tempHeight > height[i] ? tempHeight - height[i] : 0;
    }
    return res;
  }
}
