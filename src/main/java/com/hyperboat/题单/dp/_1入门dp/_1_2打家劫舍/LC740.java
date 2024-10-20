package com.hyperboat.题单.dp._1入门dp._1_2打家劫舍;

/**
 * 740. 删除并获得点数
 * <p>
 * https://leetcode.cn/problems/delete-and-earn/
 */
class LC740 {

  public int deleteAndEarn(int[] nums) {
    int max = 0;
    for (int num : nums) {
      max = Math.max(max, num);
    }
    int[] sum = new int[max + 1];
    for (int num : nums) {
      sum[num] += num;
    }
    return rob(sum);
  }

  private int rob(int[] nums) {
    int dp0 = 0;
    int dp1 = nums[0];
    for (int num : nums) {
      int t = dp1;
      dp1 = Math.max(dp1, dp0 + num);
      dp0 = t;
    }
    return dp1;
  }

}
