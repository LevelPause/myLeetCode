package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class _68文本左右对齐Test {

  @Test
  void fullJustify() {
    List<String> res = new ArrayList<>();
    res.add("This    is    an");
    res.add("example  of text");
    res.add("justification.  ");
    assertEquals(
        res, new _68文本左右对齐().fullJustify(
            new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
    List<String> res1 = new ArrayList<>();
    res1.add("What   must   be");
    res1.add("acknowledgment  ");
    res1.add("shall be        ");
    assertEquals(
        res1, new _68文本左右对齐().fullJustify(
            new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
    List<String> res2 = new ArrayList<>();
    res2.add("Science  is  what we");
    res2.add("understand      well");
    res2.add("enough to explain to");
    res2.add("a  computer.  Art is");
    res2.add("everything  else  we");
    res2.add("do                  ");
    assertEquals(
        res2, new _68文本左右对齐().fullJustify(
            new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to",
                "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"},
            20));
    List<String> res3 = new ArrayList<>();
    res3.add("Don't  go  around  saying  the");
    res3.add("world  owes  you a living; the");
    res3.add("world owes you nothing; it was");
    res3.add("here first.                   ");
    assertEquals(
        res3, new _68文本左右对齐().fullJustify(
            new String[]{"Don't", "go", "around", "saying", "the", "world", "owes", "you", "a",
                "living;", "the", "world", "owes", "you", "nothing;", "it", "was", "here",
                "first."},
            30));
  }
}