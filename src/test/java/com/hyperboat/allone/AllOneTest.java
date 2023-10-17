package com.hyperboat.allone;


import com.hyperboat.tobeclassified.allone.AllOne;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2022年06月18日 20:09
 */
public class AllOneTest {

  /**
   * ["AllOne","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","dec","dec","getMaxKey"]
   * [[],["hello"],["l"],["l"],["l"],["k"],["k"],["k"],["j"],["j"],["j"],["j"],["k"],[]]
   */
  @Test
  public void test() {
    AllOne allOne = new AllOne();
    allOne.inc("hello");
    allOne.inc("l");
    allOne.inc("l");
    allOne.inc("l");
    allOne.inc("k");
    allOne.inc("k");
    allOne.inc("k");
    allOne.inc("j");
    allOne.inc("j");
    allOne.inc("j");
    allOne.dec("j");
    allOne.dec("k");
    System.out.println(allOne.getMaxKey());
  }
}
