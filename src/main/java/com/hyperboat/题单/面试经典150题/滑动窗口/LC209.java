package com.hyperboat.题单.面试经典150题.滑动窗口;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
class LC209 {

  //常规双指针问题
  public int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
    int l = 0;
    int r = 0;
    int sum = nums[0];
    int res = Integer.MAX_VALUE;
    while (l <= r) {
      if (sum >= target) {
        res = Math.min(res, r - l + 1);
        sum -= nums[l];
        l++;
      } else {
        if (r == n - 1) {
          break;
        }
        sum += nums[++r];
      }
    }
    return res == Integer.MAX_VALUE ? 0 : res;
  }

}
