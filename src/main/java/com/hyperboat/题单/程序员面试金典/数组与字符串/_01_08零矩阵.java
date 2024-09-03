package com.hyperboat.题单.程序员面试金典.数组与字符串;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/zero-matrix-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * */
public class _01_08零矩阵 {

  public void setZeroes(int[][] matrix) {
    set1(matrix);
  }

  public void set1(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[] rows = new int[m];
    Arrays.fill(rows, 1);
    int[] cols = new int[n];
    Arrays.fill(cols, 1);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          rows[i] = 0;
          cols[j] = 0;
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (rows[i] == 0 || cols[j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  public void set2(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean row = false;
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == 0) {
        row = true;
        break;
      }
    }
    boolean col = false;
    for (int i = 0; i < n; i++) {
      if (matrix[0][i] == 0) {
        col = true;
        break;
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
    for (int i = 0; i < m; i++) {
      if (row) {
        matrix[i][0] = 0;
      }
    }
    for (int i = 0; i < n; i++) {
      if (col) {
        matrix[0][i] = 0;
      }
    }
  }
}
