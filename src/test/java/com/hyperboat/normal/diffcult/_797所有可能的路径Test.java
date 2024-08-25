package com.hyperboat.normal.diffcult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class _797所有可能的路径Test {

  @Test
  void allPathsSourceTarget() {
    int[][] graph = {{1, 2}, {3}, {3}, {}};
    List<List<Integer>> res = new ArrayList<>();
    res.add(Stream.of(0,1,3).collect(Collectors.toList()));
    res.add(Stream.of(0,2,3).collect(Collectors.toList()));
    assertEquals(res, new _797所有可能的路径().allPathsSourceTarget(graph));
  }
}