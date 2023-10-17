package com.hyperboat.nqueen;


import com.hyperboat.tobeclassified.nqueen.SolveNQueens;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2022年06月18日 20:11
 */
public class SolveNQueensTest {

  @Test
  public void test1() {
    System.out.println(new SolveNQueens().solveNQueens(4));
  }
}
