package com.hyperboat.daily.y2024.m07.d27;

/*
 * https://leetcode.cn/problems/lexicographically-smallest-string-after-operations-with-constraint/
 * */
public class _3106满足距离约束且字典序最小的字符串 {

  StringBuffer res;

  public String getSmallestString(String s, int k) {
//    res = new StringBuffer();
//    dfs(k, s);
//    return res.toString();

    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      int dis = Math.min(chars[i] - 'a', 'z' - chars[i] + 1);
      if (dis > k) {
        chars[i] -= k;
        break;
      } else {
        chars[i] = 'a';
        k -= dis;
      }
    }
    return new String(chars);
  }

  //  方法2 递归
  public void dfs(int k, String s) {
    if (k == 0 || s.equals("")) {
      res.append(s);
      return;
    }
    char first = s.charAt(0);
    int actualDis = first - 'a';
    int distance = Math.min('a' - first + 26, first - 'a');
    if (distance <= k) {
      res.append('a');
      dfs(k - distance, s.substring(1));
    } else {
      res.append((char) (first - k)).append(s.substring(1));
    }
  }


  public static void main(String[] args) {
    System.out.println('a' - 'z' + 26);
    System.out.println('z' - 'a');
  }
}
