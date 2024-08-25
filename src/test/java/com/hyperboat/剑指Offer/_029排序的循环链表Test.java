package com.hyperboat.剑指Offer;


import com.hyperboat.normal.medium.剑指Offer._029排序的循环链表;
import com.hyperboat.normal.medium.剑指Offer._029排序的循环链表.Node;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author zhangweigang
 * @date 2022年06月20日 0:50
 */
class _029排序的循环链表Test {


  @ParameterizedTest
  @MethodSource("nodeIntAndListProvider")
  void insert(_029排序的循环链表.Node head, int insertVal, int[] result) {
    Node node = new _029排序的循环链表().insert(head, insertVal);
    Assertions.assertArrayEquals(node.values(), result);
  }

  static Stream<Arguments> nodeIntAndListProvider() {
    return Stream.of(
        Arguments.of(Node.of(1), 2, new int[]{1, 2}),
        Arguments.of(Node.of(3), 2, new int[]{3, 2}),
        Arguments.of(Node.of(), 2, new int[]{2}),
        Arguments.of(Node.of(1, 2, 3, 4), 2, new int[]{1, 2, 2, 3, 4}),
        Arguments.of(Node.of(3, 4, 1, 2), 6, new int[]{3, 4, 6, 1, 2})
    );
  }
}