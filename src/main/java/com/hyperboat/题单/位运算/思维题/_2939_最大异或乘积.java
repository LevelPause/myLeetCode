package com.hyperboat.题单.位运算.思维题;

/*
 * https://leetcode.cn/problems/maximum-xor-product/description/
 * */
class _2939_最大异或乘积 {


  class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int maximumXorProduct(long a, long b, int n) {
      // 把输入数据大于等于第 n 位的部分先截出来，它们不受异或操作的影响
      var p = (a >> n) << n;
      var q = (b >> n) << n;
      for (var i = n - 1; i >= 0; i--) {
        // 看 a 和 b 第 i 位是否相同
        var x = (a >> i) & 1;
        var y = (b >> i) & 1;
        // 相同则两者都可以获得一个 1
        if (x == y) {
          p |= 1L << i;
          q |= 1L << i;
        }
        // 不同则谁小谁获得 1
        else if (p < q) {
          p |= 1L << i;
        } else {
          q |= 1L << i;
        }
      }
      // 先取个模防止乘法溢出
      p %= MOD;
      q %= MOD;
      return (int) (p * q % MOD);
    }
  }

  ;
}
