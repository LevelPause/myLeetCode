package com.hyperboat.面试经典150题.哈希表;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150
public class _128最长连续序列 {

  public int longestConsecutive(int[] nums) {
    return withSort(nums);
  }

  /* 方法1
   * 将原数组排序后, 遍历对比找到最长的, 注意去重
   * 时间复杂度就是排序的时间复杂度, O(nlog(n))
   * */
  public int withSort(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    Arrays.sort(nums);
    int res = 1;
    int curr = 1;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        continue;
      }
      if (nums[i] + 1 == nums[i + 1]) {
        curr++;
        res = Math.max(curr, res);
      } else {
        curr = 1;
      }
    }
    return res;
  }

  /* 方法2
   * 利用hashset去重
   * 先找到某一坨连续序列中的最小值(最大值)，然后逐步递增(递减)去寻找它的伙伴，记录最大的一坨的数量
   * 时间复杂度为O(n), 空间复杂度O(n)
   * */
  public int hashset(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    int res = 0;
    for (Integer item : set) {
      if (!set.contains(item + 1)) {
        int currNum = item;
        int currCount = 1;
        while (set.contains(currNum - 1)) {
          currNum -= 1;
          currCount += 1;
        }
        res = Math.max(currCount, res);
      }
    }
    return res;
  }
}
