package com.hyperboat.simple;

/**
 * @author zhangweigang
 * @date 2023年10月20日 1:10
 */
public class LC2525根据规则将箱子分类 {

  public String categorizeBox(int length, int width, int height, int mass) {
    boolean bulky = false;
    boolean heavy = false;
    //注意体积会int溢出 要转换为long
    if (length >= 10000 || width >= 10000 || height >= 10000
        || ((long) length * (long) width * (long) height) >= 1000000000L) {
      bulky = true;
    }
    if (mass >= 100) {
      heavy = true;
    }
    if (bulky & heavy) {
      return "Both";
    } else if (!bulky & !heavy) {
      return "Neither";
    } else if (bulky & !heavy) {
      return "Bulky";
    } else {
      return "Heavy";
    }
  }
}
