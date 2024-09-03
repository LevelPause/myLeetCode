package com.hyperboat.题单.面试经典150题.哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _219存在重复元素II {

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    return hasMap(nums, k);
  }

  /*方法1：hashmap的key存储nums[i]用于判断重复元素，value存储索引用于判断重复元素距离是否小于等于k*/
  public boolean hasMap(int[] nums, int k) {
    Map<Integer, Integer> num2Index = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (num2Index.containsKey(nums[i]) && Math.abs(num2Index.get(nums[i]) - i) <= k) {
        return true;
      } else {
        num2Index.put(nums[i], i);
      }

    }
    return false;
  }

  /*方法1：用hashSet维护一个固定长度的滑动窗口
   * 原理是当hashset超过k时, 移除最前头的元素
   * 在添加之前先判重，这时候重复的一定是距离在k范围之内的, 判重失败后再添加也会避免出现添加重复元素导致窗口大小和hashset大小不一致的情况
   * */
  public boolean slideWindow(int[] nums, int k) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        return true;
      }
      set.add(nums[i]);
      if (set.size() > k) {
        set.remove(nums[i - k]);
      }
    }
    return false;
  }

}
