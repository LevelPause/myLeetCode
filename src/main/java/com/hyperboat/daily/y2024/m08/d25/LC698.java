package com.hyperboat.daily.y2024.m08.d25;

import java.util.Arrays;

class LC698 {

  class Solution {


    private int k;
    private int sum;
    private int n;
    private int[] nums;

    public boolean canPartitionKSubsets(int[] nums, int k) {
      n = nums.length;
      sum = 0;
      this.nums = nums;
      this.k = k;
      for (int i = 0; i < n; i++) {
        sum += nums[i];
      }
      //总和不能被k整除, 返回false
      if (sum % k != 0) {
        return false;
      }
      //设置每组的和
      sum /= k;
      //排序, 从后往前遍历, 先挑最大的
      Arrays.sort(nums);
      return dfs(n - 1, 0, 0, new boolean[n]);
    }

    private boolean dfs(int index, int currSum, int cnt, boolean[] visited) {
      //分组选够k个了
      if (cnt == k) {
        return true;
      }
      //当前分组的和达到sum
      if (currSum == sum) {
        return dfs(n - 1, 0, cnt + 1, visited);
      }
      for (int i = index; i >= 0; i--) {
        //访问过, 当前和超出sum
        if (visited[i] || currSum + nums[i] > sum) {
          continue;
        }
        visited[i] = true;
        if (dfs(i - 1, currSum + nums[i], cnt, visited)) {
          return true;
        }
        visited[i] = false;
        //没有一个数选上,说明剩余待选的数都比sum大, 直接返回false即可
        if (currSum == 0) {
          return false;
        }
      }
      return false;
    }
  }
}
