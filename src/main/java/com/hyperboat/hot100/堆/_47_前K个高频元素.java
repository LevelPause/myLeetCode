package com.hyperboat.hot100.堆;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _47_前K个高频元素 {

  static class Solution {

    public int[] topKFrequent(int[] nums, int k) {
      return bucket(nums, k);
    }

    public int[] bucket(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
        map.merge(num, 1, Integer::sum);
      }
      List<Integer>[] list = new ArrayList[nums.length + 1];
      for (Integer key : map.keySet()) {
        int index = map.get(key);
        if (list[index] == null) {
          list[index] = new ArrayList<>();
        }
        list[index].add(key);
      }
      int[] ans = new int[k];
      int index = 0;
      for (int i = list.length - 1; i >= 0; i--) {
        if (list[i] != null) {
          for (Integer num : list[i]) {
            ans[index++] = num;
            if (index == k) {
              return ans;
            }
          }
        }
      }
      return ans;
    }


    private int[] minHeap(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
        map.merge(num, 1, Integer::sum);
      }
      int[] keys = map.keySet().stream().mapToInt(value -> value).toArray();
      buildHeap(keys, k, map);
      for (int i = k; i < keys.length; i++) {
        if (map.get(keys[i]) > map.get(keys[0])) {
          keys[0] = keys[i];
          heapify(keys, 0, k, map);
        }
      }
      int[] ans = new int[k];
      for (int i = 0; i < k; i++) {
        ans[i] = keys[k - 1 - i];
      }
      System.out.println(Arrays.toString(ans));
      return ans;

    }

    private void buildHeap(int[] heap, int heapSize, Map<Integer, Integer> map) {
      for (int i = heapSize >> 1; i >= 0; i--) {
        heapify(heap, i, heapSize, map);
      }
    }

    private void heapify(int[] heap, int i, int heapSize, Map<Integer, Integer> map) {
      int l = i * 2 + 1;
      int r = i * 2 + 2;
      int min = i;
      if (l < heapSize && map.get(heap[l]) < map.get(heap[min])) {
        min = l;
      }
      if (r < heapSize && map.get(heap[r]) < map.get(heap[min])) {
        min = r;
      }
      if (min != i) {
        swap(heap, i, min);
        heapify(heap, min, heapSize, map);
      }
    }

    private void swap(int[] heap, int a, int b) {
      int t = heap[a];
      heap[a] = heap[b];
      heap[b] = t;
    }
  }
}
