package com.hyperboat.题单.面试经典150题.数组_字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class LC68 {

  //21年的题, 到现在官方也没有更好的解, 有了新解时候再说吧
  //思路就是先把每一行确定下来, 具体方法就是贪心, 先把单词往这一行放, 超出长度就说明满了, 将多出去的这个移除即可
  //确定好每一行后, 就计算需要填充多少个空格, 根据单词个数计算每个空隙需要多少空格, 多出来的空格就按从左到右往空隙里填
  //最后将最后一行特殊处理, 间隙只填充一个空格剩余的都填充至尾部即可
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> res = new ArrayList<>();
    List<String> row = new ArrayList<>();
    int len = 0;
    for (int i = 0; i < words.length; i++) {
      row.add(words[i]);
      len += words[i].length();
      if (len + row.size() - 1 > maxWidth) {
        row.remove(row.size() - 1);
        int spaceTotal = maxWidth - (len - words[i].length());
        StringBuilder spilt = new StringBuilder();
        if (row.size() == 1) {
          StringBuilder sb = new StringBuilder(row.get(0));
          for (int i1 = 0; i1 < spaceTotal; i1++) {
            sb.append(" ");
          }
          row.set(0, sb.toString());
        } else {
          int spaceEach = spaceTotal / (row.size() - 1);
          int spaceRest = spaceTotal % (row.size() - 1);
          for (int j = 0; j < spaceEach; j++) {
            spilt.append(" ");
          }
          for (int i1 = 0; i1 < spaceRest; i1++) {
            row.set(i1, row.get(i1) + " ");
          }
        }
        res.add(String.join(spilt.toString(), row));
        len = 0;
        row = new ArrayList<>();
        i--;
      }
      if (i == words.length - 1) {
        int spaceRest = maxWidth - len - (row.size() - 1);
        StringBuilder sb = new StringBuilder(row.get(row.size() - 1));
        for (int i1 = 0; i1 < spaceRest; i1++) {
          sb.append(" ");
        }
        row.set(row.size() - 1, sb.toString());
        res.add(String.join(" ", row));
      }
    }
    return res;
  }
}
