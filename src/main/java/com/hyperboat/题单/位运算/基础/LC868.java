package com.hyperboat.题单.位运算.基础;

/**
 * 868. 二进制间距
 * <p>
 * https://leetcode.cn/problems/binary-gap/description/
 */
class LC868 {

  public int binaryGap(int n) {
    int ans = 0;
    int pre = -1;
    int curr = 0;
    while (n > 0) {
      if ((n & 1) == 1) {
        if (pre != -1) {
          ans = Math.max(ans, curr - pre);
        }
        pre = curr;
      }
      n >>= 1;
      curr++;
    }
    return ans;
  }

}
