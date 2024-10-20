package com.hyperboat.normal.diffcult;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class LC987 {

  class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  class Solution {

    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
      if (o1[0] == o2[0]) {
        if (o1[1] == o2[1]) {
          return o1[2] - o2[2];
        }
        return o1[1] - o2[1];
      }
      return o1[0] - o2[0];
    });

    public List<List<Integer>> verticalTraversal(TreeNode root) {
      dfs(root, 0, 0);
      int lastX = -1001;
      List<List<Integer>> res = new ArrayList<>();
      while (!pq.isEmpty()) {
        int[] poll = pq.poll();
        if (poll[0] != lastX) {
          List<Integer> line = new ArrayList<>();
          line.add(poll[2]);
          res.add(line);
          lastX = poll[0];
        } else {
          res.get(res.size() - 1).add(poll[2]);
        }
      }
      return res;
    }

    //    x是横坐标(列), y是纵坐标(行)
    private void dfs(TreeNode root, int x, int y) {
      if (root == null) {
        return;
      }
      pq.add(new int[]{x, y, root.val});
      dfs(root.left, x - 1, y + 1);
      dfs(root.right, x + 1, y + 1);
    }
  }
}
