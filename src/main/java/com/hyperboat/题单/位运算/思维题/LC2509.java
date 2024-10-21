package com.hyperboat.题单.位运算.思维题;

/**
 * 2509. 查询树中环的长度
 * <p>
 * https://leetcode.cn/problems/cycle-length-queries-in-a-tree/description/
 */
class LC2509 {

  public int[] cycleLengthQueries(int n, int[][] queries) {
    var len = queries.length;
    var ans = new int[len];
    for (int i = 0; i < len; i++) {
      int[] q = queries[i];
      var a = q[0];
      var b = q[1];
      var aLen = 32 - Integer.numberOfLeadingZeros(a);
      var bLen = 32 - Integer.numberOfLeadingZeros(b);
      var diff = 0;
      var same = 0;
      if (aLen > bLen) {
        diff = aLen - bLen;
        a >>= diff;
      } else {
        diff = bLen - aLen;
        b >>= diff;
      }
      while (a != b) {
        a >>= 1;
        b >>= 1;
        same++;
      }
      ans[i] = diff + same * 2 + 1;
    }
    return ans;
  }

}
