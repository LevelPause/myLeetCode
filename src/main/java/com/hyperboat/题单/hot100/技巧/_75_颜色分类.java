package com.hyperboat.题单.hot100.技巧;

public class _75_颜色分类 {

  class Solution {

    public void sortColors(int[] nums) {
      O1(nums);
    }

    private void normal(int[] nums) {
      int n = nums.length;
      int first = 0;
      int second = 0;

      for (int num : nums) {
        switch (num) {
          case 0:
            first++;
            break;
          case 1:
            second++;
            break;
        }
      }

      for (int i = 0; i < n; i++) {
        if (first > 0) {
          nums[i] = 0;
          first--;
        } else if (second > 0) {
          nums[i] = 1;
          second--;
        } else {
          nums[i] = 2;
        }
      }

    }

    private void O1(int[] nums) {
      int n = nums.length;
      int p0 = 0, p2 = n - 1;
      for (int i = 0; i <= p2; i++) {
        while (i <= p2 && nums[i] == 2) {
          swap(nums, i, p2);
          p2--;
        }
        if (nums[i] == 0) {
          swap(nums, i, p0);
          p0++;
        }
      }
    }

    private void swap(int[] nums, int i, int j) {
      int t = nums[i];
      nums[i] = nums[j];
      nums[j] = t;
    }

  }

}
