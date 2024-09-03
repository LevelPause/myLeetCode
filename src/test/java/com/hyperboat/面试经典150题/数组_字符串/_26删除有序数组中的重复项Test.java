package com.hyperboat.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.数组_字符串._26删除有序数组中的重复项;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月18日 11:12
 */
class _26删除有序数组中的重复项Test {

  @Test
  void removeDuplicates() {
    assertEquals(2,new _26删除有序数组中的重复项().removeDuplicates(new int[]{1,1,2}));
    assertEquals(1,new _26删除有序数组中的重复项().removeDuplicates(new int[]{0}));
  }
}