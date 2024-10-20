package com.hyperboat.题单.面试经典150题.双指针;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
class LC15Test {

  @Test
  void threeSum() {
    List<List<Integer>> integers1 = new ArrayList<>();
    List<Integer> int11 = new ArrayList<>();
    int11.add(-1);
    int11.add(2);
    int11.add(-1);
    List<Integer> int12 = new ArrayList<>();
    int12.add(0);
    int12.add(1);
    int12.add(-1);
    integers1.add(int11);
    integers1.add(int12);
    assertEquals(integers1, new LC15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));

    assertEquals(new ArrayList<>(), new LC15().threeSum(new int[]{0, 1, 1}));

    List<List<Integer>> integers2 = new ArrayList<>();
    List<Integer> int21 = new ArrayList<>();
    int21.add(0);
    int21.add(0);
    int21.add(0);
    integers2.add(int21);
    assertEquals(integers2, new LC15().threeSum(new int[]{0, 0, 0}));

  }
}