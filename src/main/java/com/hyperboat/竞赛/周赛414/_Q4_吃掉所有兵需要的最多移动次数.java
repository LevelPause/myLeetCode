package com.hyperboat.竞赛.周赛414;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.cn/problems/maximum-number-of-moves-to-kill-all-pawns/solutions/2909069/pai-lie-xing-zhuang-ya-dpxiang-lin-xiang-q49q/
 * */
public class _Q4_吃掉所有兵需要的最多移动次数 {

  //todo 排列型状压dp，没完全掌握
  static class Solution {

    private static final int[][] DIRS = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2},
        {1, -2},
        {2, -1}};

    public int maxMoves(int kx, int ky, int[][] positions) {
      int n = positions.length;
      // 计算马到兵的步数，等价于计算兵到其余格子的步数
      int[][][] dis = new int[n][50][50];
      for (int i = 0; i < n; i++) {
        int[][] d = dis[i];
        for (int j = 0; j < 50; j++) {
          Arrays.fill(d[j], -1);
        }
        int px = positions[i][0];
        int py = positions[i][1];
        d[px][py] = 0;
        List<int[]> q = new ArrayList<>(Collections.singletonList(new int[]{px, py}));
        for (int step = 1; !q.isEmpty(); step++) {
          List<int[]> tmp = q;
          q = new ArrayList<>();
          for (int[] p : tmp) {
            for (int[] dir : DIRS) {
              int x = p[0] + dir[0];
              int y = p[1] + dir[1];
              if (0 <= x && x < 50 && 0 <= y && y < 50 && d[x][y] < 0) {
                d[x][y] = step;
                q.add(new int[]{x, y});
              }
            }
          }
        }
      }

      int u = (1 << n) - 1;
      int[][] f = new int[1 << n][n + 1];
      for (int mask = 1; mask < (1 << n); mask++) {
        for (int i = 0; i <= n; i++) {
          int x = i < n ? positions[i][0] : kx;
          int y = i < n ? positions[i][1] : ky;
          if (Integer.bitCount(u ^ mask) % 2 == 0) { // Alice 操作
            for (int j = 0; j < n; j++) {
              if ((mask >> j & 1) > 0) {
                f[mask][i] = Math.max(f[mask][i], f[mask ^ (1 << j)][j] + dis[j][x][y]);
              }
            }
          } else { // Bob 操作
            f[mask][i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
              if ((mask >> j & 1) > 0) {
                f[mask][i] = Math.min(f[mask][i], f[mask ^ (1 << j)][j] + dis[j][x][y]);
              }
            }
          }
        }
      }
      return f[u][n];
    }
  }
}
