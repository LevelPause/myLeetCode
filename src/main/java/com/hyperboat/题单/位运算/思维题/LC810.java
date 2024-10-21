package com.hyperboat.题单.位运算.思维题;

/**
 * 810. 黑板异或游戏
 * <p>
 * https://leetcode.cn/problems/chalkboard-xor-game/description/
 */
class LC810 {

  public boolean xorGame(int[] nums) {
    var xor = 0;
    for (int x : nums) {
      xor ^= x;
    }
    return xor == 0 || (nums.length & 1) == 0;
  }

}
