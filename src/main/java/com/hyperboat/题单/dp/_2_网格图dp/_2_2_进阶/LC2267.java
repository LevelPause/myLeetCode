package com.hyperboat.题单.dp._2_网格图dp._2_2_进阶;

/**
 * 2267. 检查是否有合法括号字符串路径
 * <p>
 * https://leetcode.cn/problems/check-if-there-is-a-valid-parentheses-string-path/
 */
class LC2267 {

  private int m;
  private int n;
  private boolean[][][] visited;
  private char[][] grid;

  public boolean hasValidPath(char[][] grid) {
    m = grid.length;
    n = grid[0].length;
    this.grid = grid;
    //路径长度一定要是偶数, 路径长度为(m+n-1)
    if ((m + n) % 2 == 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
      return false;
    }
    visited = new boolean[m][n][(m + n + 1) / 2];
    return dfs(0, 0, 0);
  }

  private boolean dfs(int i, int j, int cnt) {
    //左括号过多, 剩余路径全是右括号也不够匹配
    if (cnt > m - i + n - j - 1) {
      return false;
    }
    if (i == m - 1 && j == n - 1) {
      return cnt == 1;
    }
    //重复访问
    if (visited[i][j][cnt]) {
      return false;
    }
    visited[i][j][cnt] = true;
    cnt += grid[i][j] == '(' ? 1 : -1;
    return cnt >= 0 && (i < m - 1 && dfs(i + 1, j, cnt) || j < n - 1 && dfs(i, j + 1, cnt));
  }

}
