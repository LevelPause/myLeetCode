package com.hyperboat.题单.面试经典150题.数组_字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC6 {

  //思路是对的, 换个更好的集合工具就好
  public String convert(String s, int numRows) {
    if (s.length() < 3 || numRows < 2) {
      return s;
    }
    char[][] ma = new char[numRows][s.length()];
    int i = 0;
    int j = 0;
    int index = 0;
    boolean dir = true;
    while (index < s.length()) {
      ma[i][j] = s.charAt(index);
      if (dir) {
        i++;
        if (i == numRows - 1) {
          dir = false;
        }
      } else {
        i--;
        j++;
        if (i == 0) {
          dir = true;
        }
      }
      index++;
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (char[] chars : ma) {
      for (char aChar : chars) {
        if (aChar != '\u0000') {
          stringBuilder.append(aChar);
        }
      }
    }
    return stringBuilder.toString();
  }

  //更好的集合工具成就更好的效率
  public String convert1(String s, int numRows) {
    if (s.length() < 3 || numRows < 2) {
      return s;
    }
    List<StringBuilder> rows = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      rows.add(new StringBuilder());
    }
    boolean flag = false;
    int index = 0;
    int currRow = 0;
    while (index < s.length()) {
      rows.get(currRow).append(s.charAt(index));
      if (currRow == 0 || currRow == numRows - 1) {
        flag = !flag;
      }
      currRow += flag ? 1 : -1;
      index++;
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (StringBuilder row : rows) {
      stringBuilder.append(row);
    }
    return stringBuilder.toString();
  }
}
