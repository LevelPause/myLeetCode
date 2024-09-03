package com.hyperboat.题单.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
public class _12整数转罗马数字 {

  //好弱智的题, 没什么太多优化的解, 可以把里面的字母定义成常量之类的, 没什么优化的空间
  public String intToRoman(int num) {
    if (num < 1 || num > 3999) {
      return "";
    }
    StringBuilder res = new StringBuilder();
    int curr = num;
    int single = curr % 10;
    curr /= 10;
    int ten = curr % 10;
    curr /= 10;
    int hundred = curr % 10;
    curr /= 10;
    int thousands = curr % 10;

    for (int i = 0; i < thousands; i++) {
      res.append("M");
    }

    if (hundred < 4) {
      for (int i = 0; i < hundred; i++) {
        res.append("C");
      }
    } else if (hundred > 4 && hundred < 9) {
      res.append("D");
      for (int i = 0; i < hundred - 5; i++) {
        res.append("C");
      }
    } else if (hundred == 4) {
      res.append("CD");
    } else {
      res.append("CM");
    }

    if (ten < 4) {
      for (int i = 0; i < ten; i++) {
        res.append("X");
      }
    } else if (ten > 4 && ten < 9) {
      res.append("L");
      for (int i = 0; i < ten - 5; i++) {
        res.append("X");
      }
    } else if (ten == 4) {
      res.append("XL");
    } else {
      res.append("XC");
    }

    if (single < 4) {
      for (int i = 0; i < single; i++) {
        res.append("I");
      }
    } else if (single > 4 && single < 9) {
      res.append("V");
      for (int i = 0; i < single - 5; i++) {
        res.append("I");
      }
    } else if (single == 4) {
      res.append("IV");
    } else {
      res.append("IX");
    }

    return res.toString();
  }
}
