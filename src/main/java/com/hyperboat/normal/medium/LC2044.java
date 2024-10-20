package com.hyperboat.normal.medium;


/**
 * @author hyperboat
 * @date 2022年03月15日1:33
 * <p>
 * 给你一个整数数组nums，请你找出nums子集按位或可能得到的最大值，并返回按位或能得到最大值的不同非空子集的数目。
 * <p>
 * 如果数组a可以由数组b删除一些元素（或不删除）得到，则认为数组a是数组b的一个子集。如果选中的元素下标位置不一样，则认为两个子集不同。
 * <p>
 * 对数组a执行按位或，结果等于a[0] OR a[1] OR...OR a[a.length-1]（下标从0开始）。
 * <p>
 */
class LC2044 {

  private int ans = 0;
  private int maxNum = 0;
// 会员题
  public int countMaxOrSubsets(int[] nums) {
    if (nums.length == 1) {
      return 1;
    }
    int maxNum = 0;
    for (int num : nums) {
      maxNum |= num;
    }
    this.maxNum = maxNum;
    dp(nums, 0, 0);
    return ans;
  }

  private void dp(int[] nums, int result, int index) {
    if (index == nums.length) {
      if (result == maxNum) {
        ans++;
      }
      return;
    }
    dp(nums, result, index + 1);
    dp(nums, result | nums[index], index + 1);
  }
}
