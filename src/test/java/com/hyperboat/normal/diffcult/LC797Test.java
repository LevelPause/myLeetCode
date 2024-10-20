package com.hyperboat.normal.diffcult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC797Test {

  @Test
  void allPathsSourceTarget() {
    int[][] graph = {{1, 2}, {3}, {3}, {}};
    List<List<Integer>> res = new ArrayList<>();
    res.add(Stream.of(0,1,3).collect(Collectors.toList()));
    res.add(Stream.of(0,2,3).collect(Collectors.toList()));
    assertEquals(res, new LC797().allPathsSourceTarget(graph));
  }
}