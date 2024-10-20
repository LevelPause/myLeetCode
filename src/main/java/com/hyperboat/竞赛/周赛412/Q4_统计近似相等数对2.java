package com.hyperboat.竞赛.周赛412;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Q4_统计近似相等数对2 {

  static class Solution {

    public int countPairs(int[] nums) {
      Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
      Arrays.sort(arr, Comparator.comparingInt(o -> Integer.toString(o).length()));
      int ans = 0;
      Map<Integer, Integer> cnt = new HashMap<>();
      for (Integer x : arr) {
        Set<Integer> set = new HashSet<>();
        String sStr = Integer.toString(x);
        set.add(x);
        char[] s = sStr.toCharArray();
        int len = s.length;

        for (int i = 0; i < len; i++) {
          for (int j = i + 1; j < len; j++) {
            swap(s, i, j);
            set.add(Integer.parseInt(new String(s)));
            for (int p = i + 1; p < len; p++) {
              for (int q = p + 1; q < len; q++) {
                swap(s, p, q);
                set.add(Integer.parseInt(new String(s)));
                swap(s, p, q);
              }
            }
            swap(s, i, j);
          }
        }

        for (Integer it : set) {
          ans += cnt.getOrDefault(it, 0);
        }
        cnt.merge(x, 1, Integer::sum);
      }
      return ans;
    }

    private void swap(char[] arr, int i, int j) {
      char t = arr[i];
      arr[i] = arr[j];
      arr[j] = t;
    }

    public int countPairs1(int[] nums) {
      Arrays.sort(nums);
      int n = nums.length;
      int ans = 0;
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
        if (map.containsKey(nums[i])) {
          map.put(nums[i], map.get(nums[i]) - 1);
          ans += map.get(nums[i]);
          continue;
        }
        int count = 0;
        for (int j = i + 1; j < n; j++) {
          if (isSimilar(nums[i], nums[j])) {
            count++;
            ans++;
          }
        }

        if (count > 0) {
          map.put(nums[i], count);
        }
      }
      return ans;
    }

    public int countPairs2(int[] nums) {
      int n = nums.length;
      int ans = 0;
      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
        if (map.containsKey(nums[i])) {
          List<Integer> index = map.get(nums[i]);
          Iterator<Integer> iterator = index.iterator();
          while (iterator.hasNext()) {
            int item = iterator.next();
            if (item <= i) {
              iterator.remove();
            }
          }
          ans += map.get(nums[i]).size();
          System.out.println(nums[i] + "==" + ans);
          continue;
        }

        for (int j = i + 1; j < n; j++) {
          if (isSimilar(nums[i], nums[j])) {
            List<Integer> index = map.get(nums[i]);
            if (index == null) {
              index = new ArrayList<>();
            }
            index.add(j);
            map.put(nums[i], index);
            ans++;
          }
        }
      }
      return ans;
    }


    private boolean isSimilar(int i, int j) {
      if (i == j) {
        return true;
      }
      int lenI = 32 - Integer.numberOfLeadingZeros(i);
      int lenJ = 32 - Integer.numberOfLeadingZeros(j);
      int len = Math.max(lenI, lenJ);
      int diffCount = 0;
      int[] diffI = new int[4];
      int[] diffJ = new int[4];
      while (len-- > 0) {
        if (j % 10 != i % 10) {
          if (++diffCount > 4) {
            break;
          }
          diffI[diffCount - 1] = i % 10;
          diffJ[diffCount - 1] = j % 10;
        }
        j /= 10;
        i /= 10;
      }

      if (diffCount == 2 || diffCount == 3 || diffCount == 4) {
        boolean flag = true;
        if (diffCount == 4) {
          flag = false;
          for (int k = 1; k < 4; k++) {
            if (diffI[0] == diffJ[k] && diffI[k] == diffJ[0]) {
              flag = true;
              break;
            }
          }
        }
        Arrays.sort(diffI);
        Arrays.sort(diffJ);
        if (flag && Arrays.equals(diffI, diffJ)) {
          return true;
        }
      } else if (diffCount == 0) {
        return true;
      }
      return false;
    }
  }


}
