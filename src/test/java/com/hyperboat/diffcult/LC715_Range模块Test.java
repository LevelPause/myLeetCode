package com.hyperboat.diffcult;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2022年06月20日 5:25
 */
class LC715_Range模块Test {

  @Test
  void addRange() {
    LC715_Range模块 rangeModule = new LC715_Range模块();
    rangeModule.addRange(10, 20);
    rangeModule.removeRange(14, 16);
    assertTrue(rangeModule.queryRange(10, 14)); /*返回 true （区间 [10, 14) 中的每个数都正在被跟踪）*/
    assertFalse(
        rangeModule.queryRange(13, 15)); /*返回 false（未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）*/
    assertTrue(rangeModule.queryRange(16, 17)); /*返回 true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）*/

  }

  @Test
  void queryRange() {
  }

  @Test
  void removeRange() {
  }
}