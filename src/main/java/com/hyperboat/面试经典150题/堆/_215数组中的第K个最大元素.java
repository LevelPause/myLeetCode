package com.hyperboat.面试经典150题.堆;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _215数组中的第K个最大元素 {

  public int findKthLargest(int[] nums, int k) {
    List<Integer> target = new ArrayList<>();
    for (int num : nums) {
      target.add(num);
    }
    return quickSelect(target, k);
  }

  // 方法1 桶排序, 基于此题值域只有20000的情况下, 还是比较适合的，时间复杂度为O(n)
  public int bucketSelect(int[] nums, int k) {
    int[] bucket = new int[20001];
    for (int num : nums) {
      bucket[num + 10000]++;
    }
    for (int i = bucket.length - 1; i >= 0; i--) {
      k -= bucket[i];
      if (k <= 0) {
        return i - 10000;
      }
    }
    return 0;
  }

  //方法2 优化快排, 三路划分, 在划分子数组过程中遇到了了第k个大的数时，直接返回，综合时间复杂度也是O(n)
  public int quickSelect(List<Integer> nums, int k) {
    Random random = new Random();
    int curr = nums.get(random.nextInt(nums.size()));
    List<Integer> small = new ArrayList<>();
    List<Integer> equals = new ArrayList<>();
    List<Integer> big = new ArrayList<>();
    for (Integer num : nums) {
      if (num == curr) {
        equals.add(num);
      } else if (num < curr) {
        small.add(num);
      } else {
        big.add(num);
      }
    }
    if (big.size() >= k) {
      return quickSelect(big, k);
    } else if (big.size() + equals.size() < k) {
      return quickSelect(small, k - (big.size() + equals.size()));
    }
    return curr;
  }

  //方法3 小根堆（小根堆是一种二叉树结构，其特点是父节点小于其左右孩子节点，因此堆顶是最小的元素）
// 先把前k个元素构建成小根堆,；
// 然后依次将剩余的元素与堆顶的元素比较；
// 比堆顶大就加入堆，然后重新构建小根堆，否则跳过；
//  遍历完成后，堆顶的元素就是第k个大的元素。
  public int minHeapSelect(int[] nums, int k) {
    buildMinHeap(nums, k);
    for (int i = k; i < nums.length; i++) {
      if (nums[i] > nums[0]) {
        swap(nums, 0, i);
        minHeap(nums, 0, k);
      }
    }
    return nums[0];
  }

  public void buildMinHeap(int[] nums, int heapSize) {
    for (int i = heapSize - 1; i >= 0; i--) {
      minHeap(nums, i, heapSize);
    }
  }

  public void minHeap(int[] nums, int i, int heapSize) {
    int l = i * 2 + 1;
    int r = i * 2 + 2;
    int min = i;
    if (l < heapSize && nums[l] < nums[min]) {
      min = l;
    }
    if (r < heapSize && nums[r] < nums[min]) {
      min = r;
    }
    if (min != i) {
      swap(nums, i, min);
      minHeap(nums, min, heapSize);
    }
  }

  public void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }

}
