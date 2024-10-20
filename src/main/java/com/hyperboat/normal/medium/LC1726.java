package com.hyperboat.normal.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangweigang
 * @date 2023年10月19日 4:46
 */
class LC1726 {

  public int tupleSameProduct(int[] nums) {
    int len = nums.length;
    if (len < 4) {
      return 0;
    }
    //把两两相乘的乘积和对应出现的次数放入map中
    Map<Integer, Integer> multiMap = new HashMap<>();
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        int multi = nums[i] * nums[j];
        Integer count = multiMap.getOrDefault(multi, 0);
        multiMap.put(multi, count + 1);
      }
    }
    int res = 0;
    //对于相同的乘积能组成的元组个数为C n 2  * 8
    for (Integer value : multiMap.values()) {
      res += value * (value - 1) / 2 * 8;
    }
    return res;
  }
}
