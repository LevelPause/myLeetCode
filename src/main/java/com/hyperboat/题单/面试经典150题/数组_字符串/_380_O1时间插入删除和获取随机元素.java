package com.hyperboat.题单.面试经典150题.数组_字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author zhangweigang
 * @date 2023年10月20日 5:29
 */
public class _380_O1时间插入删除和获取随机元素 {

  private List<Integer> nums;
  private Map<Integer, Integer> map;
  private Random random;

  /**
   * Initialize your data structure here.
   */
  public _380_O1时间插入删除和获取随机元素() {
    nums = new ArrayList<>();
    map = new HashMap<>();
    random = new Random();
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified
   * element.
   */
  public boolean insert(int val) {
    if (map.get(val) != null) {
      return false;
    } else {
      nums.add(val);
      map.put(val, nums.size() - 1);
      return true;
    }
  }

  /**
   * Removes a value from the set. Returns true if the set contained the specified element.
   */
  public boolean remove(int val) {
    Integer index = map.get(val);
    if (index == null) {
      return false;
    } else {
      int last = nums.get(nums.size() - 1);
      nums.set(index, last);
      nums.remove(nums.size() - 1);
      map.put(last, index);
      map.remove(val);
      return true;
    }
  }

  /**
   * Get a random element from the set.
   */
  public int getRandom() {
    int i = random.nextInt(nums.size());
    return nums.get(i);
  }
}
