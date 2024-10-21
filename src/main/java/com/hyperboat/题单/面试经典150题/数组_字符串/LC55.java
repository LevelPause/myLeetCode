package com.hyperboat.题单.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月19日 3:45
 */
class LC55 {

  //进阶解法
  public boolean canJump(int[] nums) {
    int maxLocation = nums[0];
    for (int i = 0; i < nums.length; i++) {
      //最远距离超过数组长度
      if (maxLocation >= nums.length) {
        return true;
      }
      // 这个比较难懂: 意思是i走到了最远距离达不到的位置,即遍历到了不可达的位置
      if (i > maxLocation) {
        return false;
      }
      //更新最远能到达的距离
      maxLocation = Math.max(maxLocation, nums[i] + i);
    }
    return true;
  }

  //dp 超时
  public boolean canJump1(int[] nums) {
    return dp(0, nums.length - 1, nums);
  }

  //dp 超时
  private boolean dp(int currIndex, int maxIndex, int[] nums) {
    if (currIndex >= maxIndex) {
      return true;
    }
    for (int i = 1; i <= nums[currIndex]; i++) {
      if (dp(currIndex + i, maxIndex, nums)) {
        return true;
      }
    }
    return false;
  }
}
