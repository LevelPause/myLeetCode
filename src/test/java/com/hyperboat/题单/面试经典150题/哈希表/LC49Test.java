package com.hyperboat.题单.面试经典150题.哈希表;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class LC49Test {

  @Test
  void groupAnagrams() {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> res = new ArrayList<>();
    res.add(Stream.of("eat", "tea", "ate").collect(Collectors.toList()));
    res.add(Stream.of("tan", "nat").collect(Collectors.toList()));
    res.add(Stream.of("bat").collect(Collectors.toList()));
    assertEquals(res, new LC49().groupAnagrams(strs));
  }
}