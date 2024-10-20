package com.hyperboat.daily.y2024.m06.d01;

// https://leetcode.cn/problems/distribute-candies-among-children-i/description/
// 给你两个正整数 n 和 limit 。
// 请你将 n 颗糖果分给 3 位小朋友，确保没有任何小朋友得到超过 limit 颗糖果，请你返回满足此条件下的 总方案数 。
class _2928给小朋友们分糖果I {

  // 暴力枚举解法o(limit*limit)
  public int distributeCandies(int n, int limit) {
    int res = 0;
    // 第一个小朋友
    for (int i = 0; i <= limit; i++) {
      // 第二个小朋友
      for (int j = 0; j <= limit; j++) {
        if (i + j > n) {
          break;
        }
        //第三个小朋友
        if (n - i - j <= limit) {
          res++;
        }
      }
    }
    return res;
  }

  // 优化枚举(o(Min(n,limit)))
  public int distributeCandies2(int n, int limit) {
    int res = 0;
    // 第一个小朋友
    for (int i = 0; i <= Math.min(limit, n); i++) {
      if (n - i > limit * 2) {
        continue;
      }
      int max = Math.max(0, n - i - limit);
      int min = Math.min(limit, n - i);
      res += max - min + 1;
    }
    return res;
  }

  //数学容斥思想(补集)(o(1))
  public int distributeCandies3(int n, int limit) {
    return cal(n + 2) - 3 * cal(n - limit + 1) + 3 * cal(n - (limit + 1) * 2 + 2) - cal(
        n - 3 * (limit + 1) + 2);
  }

  private int cal(int x) {
    return x > 1 ? x * (x - 1) / 2 : 0;
  }

}
