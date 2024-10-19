package com.hyperboat.normal.diffcult;


import com.hyperboat.normal.diffcult.LC432;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2022年06月18日 20:09
 */
public class LC432Test {

  /**
   * ["AllOne","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","dec","dec","getMaxKey"]
   * [[],["hello"],["l"],["l"],["l"],["k"],["k"],["k"],["j"],["j"],["j"],["j"],["k"],[]]
   */
  @Test
  public void test() {
    LC432 LC432 = new LC432();
    LC432.inc("hello");
    LC432.inc("l");
    LC432.inc("l");
    LC432.inc("l");
    LC432.inc("k");
    LC432.inc("k");
    LC432.inc("k");
    LC432.inc("j");
    LC432.inc("j");
    LC432.inc("j");
    LC432.dec("j");
    LC432.dec("k");
    System.out.println(LC432.getMaxKey());
  }
}
