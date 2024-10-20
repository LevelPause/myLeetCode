package com.hyperboat.竞赛.周赛414;

import java.util.List;

class _Q3_到达数组末尾的最大得分 {

  class Solution {

    public long findMaximumScore(List<Integer> nums) {
      long ans = 0L;
      int n = nums.size();
      int pre = 0;
      int i = 1;
      while (i < n) {
        if (nums.get(i) > nums.get(pre)||(i == n - 1 && pre != i)) {
          ans += (long) nums.get(pre) * (i - pre);
          pre = i;
        }
        i++;
      }

      return ans;
    }
  }
}
