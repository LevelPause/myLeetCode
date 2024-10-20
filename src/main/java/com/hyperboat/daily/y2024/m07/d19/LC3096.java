package com.hyperboat.daily.y2024.m07.d19;

class LC3096 {

  // 前缀和问题
  public int minimumLevels(int[] possible) {
    int ans = -1;
    int n = possible.length;
    int[] a = new int[n];
    int[] b = new int[n];
    a[0] = possible[0] == 1 ? 1 : -1;
    b[n - 1] = possible[n - 1] == 1 ? 1 : -1;
    for (int i = 1; i < n; i++) {
      if (possible[i] == 1) {
        a[i] = a[i - 1] + 1;
      } else {
        a[i] = a[i - 1] - 1;
      }
      if (possible[(n - 1) - i] == 1) {
        b[(n - 1) - i] = b[(n - 1) - i + 1] + 1;
      } else {
        b[(n - 1) - i] = b[(n - 1) - i + 1] - 1;
      }
    }
    for (int i = 0; i < n - 1; i++) {
      if (a[i] - b[i + 1] > 0) {
        ans = i + 1;
        break;
      }
    }
    return ans;
  }

  //  优化空间写法
  public int minimumLevels1(int[] possible) {
    int n = possible.length;
//    所有题的总分数
    int total = 0;
    for (int j : possible) {
      total += j == 1 ? 1 : -1;
    }
//    a所得分数
    int score = 0;
    for (int i = 0; i < n - 1; i++) {
      score += possible[i] == 1 ? 1 : -1;
      if (score > total - score) {
        return i + 1;
      }
    }
    return -1;
  }
}
