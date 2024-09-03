package com.hyperboat.面试经典150题.哈希表;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hyperboat.题单.面试经典150题.哈希表._49字母异位词分组;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class _49字母异位词分组Test {

  @Test
  void groupAnagrams() {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> res = new ArrayList<>();
    res.add(Stream.of("bat").collect(Collectors.toList()));
    res.add(Stream.of("nat", "tan").collect(Collectors.toList()));
    res.add(Stream.of("ate", "eat", "tea").collect(Collectors.toList()));
    assertEquals(res, new _49字母异位词分组().groupAnagrams(strs));
  }
}