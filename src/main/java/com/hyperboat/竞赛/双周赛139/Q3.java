package com.hyperboat.竞赛.双周赛139;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/find-the-maximum-sequence-value-of-array/description/
 * */
class Q3 {

  //todo 没有完全掌握, 有空再看看
  class Solution {

    private static final int BIT_WIDTH = 7;

    public int maxValue(int[] nums, int k) {
      final int MX = 1 << BIT_WIDTH;
      int n = nums.length;
      int k2 = Math.min(k, BIT_WIDTH); // 至多选 k2 个数

      boolean[][] suf = new boolean[n - k + 1][];
      boolean[][] f = new boolean[k2 + 1][MX];
      f[0][0] = true;
      int[] maxI = new int[MX];
      int[] cnt = new int[MX];
      for (int i = n - 1; i >= k; i--) {
        int v = nums[i];
        for (int j = Math.min(k2 - 1, n - 1 - i); j >= 0; j--) {
          for (int x = 0; x < MX; x++) {
            if (f[j][x]) {
              f[j + 1][x | v] = true;
            }
          }
        }
        if (i <= n - k) {
          suf[i] = f[k2].clone();
        }
        // 枚举 v 的超集
        for (int s = v; s < MX; s = (s + 1) | v) {
          if (++cnt[s] == k) {
            // 从 n-1 开始遍历，至少要遍历到 i 才有可能找到 k 个数 OR 等于 s
            maxI[s] = i;
          }
        }
      }

      int ans = 0;
      boolean[][] pre = new boolean[k2 + 1][MX];
      pre[0][0] = true;
      int[] minI = new int[MX];
      Arrays.fill(minI, Integer.MAX_VALUE);
      Arrays.fill(cnt, 0);
      int[] a = new int[MX];
      int[] b = new int[MX];
      for (int i = 0; i < n - k; i++) {
        int v = nums[i];
        for (int j = Math.min(k2 - 1, i); j >= 0; j--) {
          for (int x = 0; x < MX; x++) {
            if (pre[j][x]) {
              pre[j + 1][x | v] = true;
            }
          }
        }
        // 枚举 v 的超集
        for (int s = v; s < MX; s = (s + 1) | v) {
          if (++cnt[s] == k) {
            // 从 0 开始遍历，至少要遍历到 i 才有可能找到 k 个数 OR 等于 s
            minI[s] = i;
          }
        }
        if (i < k - 1) {
          continue;
        }
        int na = 0;
        int nb = 0;
        for (int x = 0; x < MX; x++) {
          if (pre[k2][x] && minI[x] <= i) {
            a[na++] = x;
          }
          if (suf[i + 1][x] && maxI[x] > i) {
            b[nb++] = x;
          }
        }
        ans = Math.max(ans, findMaximumXOR(a, na, b, nb));
        if (ans == MX - 1) {
          return ans;
        }
      }
      return ans;
    }

    // 421. 数组中两个数的最大异或值
    // 改成两个数组的最大异或和值，做法是类似的，仍然可以用【试填法】解决
    private int findMaximumXOR(int[] a, int n, int[] b, int m) {
      int ans = 0;
      int mask = 0;
      boolean[] seen = new boolean[1 << BIT_WIDTH];
      for (int i = BIT_WIDTH - 1; i >= 0; i--) { // 从最高位开始枚举
        mask |= 1 << i;
        int newAns = ans | (1 << i); // 这个比特位可以是 1 吗？
        Arrays.fill(seen, false);
        for (int j = 0; j < n; j++) {
          seen[a[j] & mask] = true; // 低于 i 的比特位置为 0
        }
        for (int j = 0; j < m; j++) {
          int x = b[j] & mask; // 低于 i 的比特位置为 0
          if (seen[newAns ^ x]) {
            ans = newAns; // 这个比特位可以是 1
            break;
          }
        }
      }
      return ans;
    }
  }
}
