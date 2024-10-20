package com.hyperboat.题单.dp._2_网格图dp._2_2_进阶;

import java.util.List;

/**
 * 1301. 最大得分的路径数目
 * <p>
 * https://leetcode.cn/problems/number-of-paths-with-max-score/description/
 */
class LC1301 {

  static final int MOD = 1000000007;
  int[] dx = new int[]{-1, -1, 0};
  int[] dy = new int[]{0, -1, -1};

  public int[] pathsWithMaxScore(List<String> board) {
    int m = board.size();
    int n = board.get(0).length();
    int[][][] dp = new int[m][n][2];
    dp[0][0][0] = 0;
    dp[0][0][1] = 1;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        char c = board.get(i).charAt(j);
        if (c == 'X') {
          dp[i][j][0] = Integer.MIN_VALUE;
          dp[i][j][1] = 0;
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        char c = board.get(i).charAt(j);
        if (!Character.isDigit(c) && !(i == m - 1 && j == n - 1)) {
          continue;
        }
        int val = (i == m - 1 && j == n - 1) ? 0 : (c - '0');
        int maxScore = Integer.MIN_VALUE;
        int maxScoreCount = 0;
        for (int k = 0; k < dx.length; k++) {
          int x = i + dx[k];
          int y = j + dy[k];
          if (x >= 0 && x < m && y >= 0 && y < n && dp[x][y][0] > maxScore) {
            maxScore = dp[x][y][0];
            maxScoreCount = dp[x][y][1];
          } else if (x >= 0 && x < m && y >= 0 && y < n && dp[x][y][0] == maxScore) {
            maxScoreCount += dp[x][y][1];
            maxScoreCount %= MOD;
          }
        }
        dp[i][j][0] = (maxScore == Integer.MIN_VALUE) ? Integer.MIN_VALUE : (maxScore + val);
        dp[i][j][1] = maxScoreCount;
      }
    }
    return dp[m - 1][n - 1][0] == Integer.MIN_VALUE ? new int[]{0, 0} : dp[m - 1][n - 1];
  }

}
