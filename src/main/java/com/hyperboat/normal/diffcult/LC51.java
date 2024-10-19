package com.hyperboat.normal.diffcult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hyperboat
 * @date 2022年03月14日 22:23
 * <p>
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class LC51 {



  final List<List<String>> result = new ArrayList<>();


  public List<List<String>> solveNQueens(int n) {
    char[][] currentResult = new char[n][n];
    for (char[] chars : currentResult) {
      Arrays.fill(chars, '.');
    }
    dfs(currentResult, 0);

    return result;
  }

  private void dfs(char[][] chars, int row) {
    if (row == chars.length) {
      result.add(toResult(chars));
      return;
    }
    for (int column = 0; column < chars.length; column++) {
      if (isValid(chars, row, column)) {
        chars[row][column] = 'Q';
        dfs(chars, row + 1);
        chars[row][column] = '.';
        if (column == chars.length - 1) {
          return;
        }
      }
    }
  }

  private boolean isValid(char[][] chars, int row, int column) {
    for (int myRow = 0; myRow < row; myRow++) {
      //判断正上方冲突
      if (chars[myRow][column] == 'Q') {
        return false;
      }
      //判断左上冲突
      int upperLeftColumn = column - (row - myRow);
      if (upperLeftColumn < chars.length
          && upperLeftColumn >= 0
          && chars[myRow][upperLeftColumn] == 'Q') {
        return false;
      }
      //判断右上冲突
      int upperRightColumn = column + (row - myRow);
      if (upperRightColumn < chars.length
          && upperRightColumn >= 0
          && chars[myRow][upperRightColumn] == 'Q') {
        return false;
      }
    }
    return true;
  }

  private List<String> toResult(char[][] chars) {
    List<String> result = new ArrayList<>();
    for (char[] aChar : chars) {
      result.add(new String(aChar));
    }
    return result;
  }
}
