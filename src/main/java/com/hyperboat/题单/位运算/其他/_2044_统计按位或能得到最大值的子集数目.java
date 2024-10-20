package com.hyperboat.题单.位运算.其他;

/**
 * https://leetcode.cn/problems/count-number-of-maximum-bitwise-or-subsets/description/
 */
class _2044_统计按位或能得到最大值的子集数目 {

  class Solution {

    private int all;
    private int[] nums;

    public int countMaxOrSubsets(int[] nums) {
      all = 0;
      for (int x : nums) {
        all |= x;
      }
      this.nums = nums;
      return dfs(0, 0);
    }

    private int dfs(int pos, int or) {
      //剪枝, pos之后的子集都符合条件
      if (or == all) {
        return 1 << (nums.length - pos);
      }
      if (pos == nums.length) {
        return 0;
      }
      return dfs(pos + 1, or) + dfs(pos + 1, or | nums[pos]);
    }
  }
}
