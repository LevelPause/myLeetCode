package com.hyperboat.hot100.动态规划;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _118_杨辉三角 {

  class Solution {

    public List<List<Integer>> generate(int numRows) {
      int index = 1;
      List<List<Integer>> res = new ArrayList<>();
      res.add(Collections.singletonList(1));
      while (index < numRows) {
        if (res.size() == index) {
          res.add(new ArrayList<>());
        }
        List<Integer> line = res.get(index);
        for (int i = 0; i <= index; i++) {
          int curr = 1;
          if (i > 0 && i < index) {
            curr = res.get(index - 1).get(i - 1) + res.get(index - 1).get(i);
          }
          line.add(curr);
        }
        index++;
      }
      return res;
    }
  }
}
