package com.hyperboat.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.面试经典150题.数组_字符串.LC80删除有序数组中的重复项II;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月18日 11:39
 */
class LC80删除有序数组中的重复项IITest {

  @Test
  void removeDuplicates() {
    assertEquals(5,new LC80删除有序数组中的重复项II().removeDuplicates(new int[]{1,1,1,2,2,3}));
  }
}