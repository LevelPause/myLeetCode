package com.hyperboat.题单.位运算.其他;

/**
 * 2438. 二的幂数组中查询范围内的乘积
 * <p>
 * https://leetcode.cn/problems/range-product-queries-of-powers/description/
 */
class LC2438 {

  private static final int MOD = (int) 1e9 + 7;

  public int[] productQueries(int n, int[][] queries) {

    //获取power数组
    var bitCount = Integer.bitCount(n);
    var power = new int[bitCount];
    for (int i = 0; i < bitCount; i++) {
      var lowbit = n & -n;
      power[i] = lowbit;
      n ^= lowbit;
    }

    //预处理结果, 因为power数组的长度很小, 所以预处理对于问询更省时间
    var res = new int[bitCount][bitCount];
    for (int i = 0; i < bitCount; i++) {
      res[i][i] = power[i];
      for (int j = i + 1; j < bitCount; j++) {
        //注意整数溢出的问题
        res[i][j] = (int) (((long) res[i][j - 1] * power[j]) % MOD);
      }
    }

    //回答问询
    var len = queries.length;
    var ans = new int[len];
    for (int i = 0; i < len; i++) {
      var l = queries[i][0];
      var r = queries[i][1];
      ans[i] = res[l][r];
    }
    return ans;
  }


}
