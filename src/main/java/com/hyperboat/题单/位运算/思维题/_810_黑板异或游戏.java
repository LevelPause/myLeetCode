package com.hyperboat.题单.位运算.思维题;

/**
 * https://leetcode.cn/problems/chalkboard-xor-game/description/
 */
class _810_黑板异或游戏 {

  class Solution {

    public boolean xorGame(int[] nums) {
      var xor = 0;
      for (int x : nums) {
        xor ^= x;
      }
      return xor == 0 || (nums.length & 1) == 0;
    }
  }
}
