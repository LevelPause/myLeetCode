package com.hyperboat.normal.tobeclassified._0904;

public class _01 {

  public static void main(String[] args) {
    for (int i = 0; i < 50; i++) {
      System.out.print(new _01().fib(i));
      System.out.print("-");
    }
  }

  /**
   * 滑动数组实现斐波那契
   *
   * @param n 斐波那契数列长度
   * @return 第n个斐波那契数的值
   */
  public int fib(int n) {
    if (n < 2) {
      return n;
    }
    int MOD = 1000000007;
    int first = 0;
    int second = 1;
    int res;
    int index = 2;
    do {
      res = (first + second) % MOD;
      first = second;
      second = res;
      index++;
    } while (index <= n);
    return res;
  }

  public int fib2(int n) {
    if (n < 0) {
      throw new RuntimeException("参数不合法");
    }
    if (n < 2) {
      return n;
    }
    return n;
  }
}
