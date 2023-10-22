package com.hyperboat.diffcult;

import java.util.Arrays;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
public class LC1402做菜顺序 {

  //好简单的一道题, 用最基本的贪心原理, 先排序, 按从大到小依次加入结果, 如果当前satisfaction加入后使结果变少了,就舍弃
  public int maxSatisfaction(int[] satisfaction) {
    int res = 0;
    int n = satisfaction.length;
    Arrays.sort(satisfaction);
    int sumSatisfaction = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (res + sumSatisfaction + satisfaction[i] > res) {
        res = res + sumSatisfaction + satisfaction[i];
        sumSatisfaction += satisfaction[i];
      }
    }
    return res;
  }
}
