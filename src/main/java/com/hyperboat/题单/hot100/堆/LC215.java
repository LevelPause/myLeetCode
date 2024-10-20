package com.hyperboat.题单.hot100.堆;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 215. 数组中的第K个最大元素
 * <p>
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 */
class LC215 {

  private Random random = new Random();

  public int findKthLargest(int[] nums, int k) {
//      return minHeap(nums, k);
    return quickSelect(Arrays.stream(nums).boxed().collect(Collectors.toList()), k);

  }

  private int quickSelect(List<Integer> target, int k) {
    int curr = target.get(random.nextInt(target.size()));
    List<Integer> big = new ArrayList<>();
    List<Integer> small = new ArrayList<>();
    List<Integer> equals = new ArrayList<>();
    for (Integer i : target) {
      if (i == curr) {
        equals.add(i);
      } else if (i < curr) {
        small.add(i);
      } else {
        big.add(i);
      }
    }
    if (big.size() >= k) {
      return quickSelect(big, k);
    } else if (big.size() + equals.size() < k) {
      return quickSelect(small, k - (big.size() + equals.size()));
    } else {
      return curr;
    }
  }

  private int minHeap(int[] nums, int k) {
    buildHeap(nums, k);
    int n = nums.length;
    for (int i = k; i < n; i++) {
      if (nums[i] > nums[0]) {
        nums[0] = nums[i];
        heapify(nums, 0, k);
      }
    }
    return nums[0];
  }

  private void buildHeap(int[] nums, int heapSize) {
    for (int i = heapSize >> 1; i >= 0; i--) {
      heapify(nums, i, heapSize);
    }
  }

  private void heapify(int[] nums, int i, int heapSize) {
    int l = i * 2;
    int r = i * 2 + 1;
    int min = i;
    if (l < heapSize && nums[l] < nums[min]) {
      min = l;
    }
    if (r < heapSize && nums[r] < nums[min]) {
      min = r;
    }
    if (min != i) {
      swap(nums, i, min);
      heapify(nums, min, heapSize);
    }
  }

  private void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }

}
