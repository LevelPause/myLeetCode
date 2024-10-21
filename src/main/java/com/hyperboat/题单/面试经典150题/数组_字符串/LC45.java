package com.hyperboat.题单.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月20日 1:45
 */
class LC45 {

  public int jump(int[] nums) {
    int n = nums.length;
    int res = 0;
    int end = 0;
    int maxPos = 0;
    for (int i = 0; i < n - 1; i++) {
      maxPos = Math.max(nums[i] + i, maxPos);
      //i走到了这一步的尽头, 再往前走, 就要多跳一步
      if (i == end) {
        end = maxPos;
        res++;
      }
    }
    return res;
  }

  public int jump2(int[] nums) {
    int n = nums.length;
    if (n <= 1) {
      return 0;
    }
    //dp[i]表示到达i位置所用的最小跳跃数, dp[n-1]即答案
    int[] dp = new int[n];
    dp[0] = 0;
    if (nums[0] >= n) {
      return 1;
    }
    for (int i = 1; i <= nums[0]; i++) {
      dp[i] = dp[0] + 1;
    }
    int index = 1;

    while (index < n) {
      //非0的都是前人已开采的土地, 用的步数肯定比当前的少 所以跳过
      dp[index] = dp[index] == 0 ? dp[index - 1] + 1 : dp[index];
      for (int i = 1; i <= nums[index]; i++) {
        //防止数组越界
        if (i + index >= n) {
          return dp[n - 1];
        }
        dp[i + index] = dp[i + index] == 0 ? dp[index] + 1 : dp[i + index];
      }
      index++;
    }
    return dp[n - 1];
  }

}
