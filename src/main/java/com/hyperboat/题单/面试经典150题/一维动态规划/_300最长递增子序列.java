package com.hyperboat.题单.面试经典150题.一维动态规划;

import java.util.ArrayList;
import java.util.List;

class _300最长递增子序列 {

  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    dp[0] = 1;
    int ans = 1;
    for (int i = 1; i < n; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      ans = Math.max(ans, dp[i]);
    }
    return ans;
  }

  //  二分+贪心, 贪心是维护已组成的子序列的最小值以让子序列上限增长的尽可能慢，二分是为了替换最小值
  public int nlogn(int[] nums) {
    int n = nums.length;
//    ansList.get(i)表示 长度为 i+1 的上升子序列的末尾元素中的最小值。
    List<Integer> ansList = new ArrayList<>();
    ansList.add(nums[0]);
    for (int i = 1; i < n; i++) {
      int last = ansList.size() - 1;
      if (nums[i] > ansList.get(last)) {
        ansList.add(nums[i]);
      } else {
//        二分
        int l = 0, r = last;
        while (l < r) {
          int m = (l + r) >> 1;
          if (nums[i] <= ansList.get(m)) {
            r = m + 1;
          } else {
            l = m - 1;
          }
        }
        ansList.set(l, nums[i]);
      }
    }
    return ansList.size();
  }
}
