package com.hyperboat.normal.diffcult;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Range模块是跟踪数字范围的模块。设计一个数据结构来跟踪表示为 半开区间 的范围并查询它们。
 * <p>
 * 半开区间[left, right)表示所有left <= x < right的实数 x 。
 * <p>
 * 实现 RangeModule 类:
 * <p>
 * RangeModule()初始化数据结构的对象。 void addRange(int left, int right) 添加 半开区间[left,
 * right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间[left, right)中尚未跟踪的任何数字到该区间中。 boolean queryRange(int
 * left, int right)只有在当前正在跟踪区间[left, right)中的每一个实数时，才返回 true，否则返回 false 。 void removeRange(int left,
 * int right)停止跟踪 半开区间[left, right)中当前正在跟踪的每个实数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入 ["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"] [[], [10,
 * 20], [14, 16], [10, 14], [13, 15], [16, 17]] 输出 [null, null, null, true, false, true]
 * <p>
 * 解释 RangeModule rangeModule = new RangeModule(); rangeModule.addRange(10, 20);
 * rangeModule.removeRange(14, 16); rangeModule.queryRange(10, 14); 返回 true （区间 [10, 14)
 * 中的每个数都正在被跟踪） rangeModule.queryRange(13, 15); 返回 false（未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）
 * rangeModule.queryRange(16, 17); 返回 true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）
 *  @author zhangweigang
 *  @date 2022年06月20日 2:39
 */
class LC715 {
//TODO  正确性有待验证
  private final Node node;

  public LC715() {
    node = new Node();
  }

  public void addRange(int left, int right) {
    //子集
    if (left >= node.start && right <= node.end) {
      node.mergeExclude(left, right);
      return;
    }
    if (node.start > right) {
      node.start = left;
    }
    if (node.end < left) {
      node.end = right;
    }
    if (node.start <= left && node.end <= right) {
      node.mergeExclude(left, node.end);
      node.end = right;
    }
    if (node.end >= right && node.start >= left) {
      node.mergeExclude(node.start, right);
      node.start = left;
    }
  }

  public boolean queryRange(int left, int right) {
    return node.queryRange(left, right);
  }

  public void removeRange(int left, int right) {
    int myLeft = Math.max(left, node.start);
    int myRight = Math.max(right, node.end);
    boolean shouldAddNew = true;
    for (Exclude exclude : node.excludes) {
      //子集
      if (exclude.start <= myLeft && exclude.end >= myRight) {
        //do nothing
        return;
      }
      //左边界超出, 增大左边界
      if (exclude.start > myLeft) {
        exclude.start = myLeft;
        shouldAddNew = false;
      }
      //右边界超出, 增大右边界
      if (exclude.end < myRight) {
        exclude.end = myRight;
        shouldAddNew = false;
      }
    }
    //与所有的都没有交集, 增加新集合区间
    if (shouldAddNew) {
      node.excludes.add(new Exclude(myLeft, myRight));
    }
  }

  class Node {

    private int start;
    private int end;
    private final List<Exclude> excludes;

    public Node(int start, int end) {
      this.start = start;
      this.end = end;
      excludes = new ArrayList<>();
    }

    public Node() {
      excludes = new ArrayList<>();
    }

    public boolean queryRange(int left, int right) {
      if (left < start || right > end) {
        return false;
      }
      for (Exclude exclude : excludes) {
        //和排除区间有交集
        if (!(exclude.start > right || exclude.end < left)) {
          return false;
        }
      }
      return true;
    }

    public void mergeExclude(int left, int right) {
      for (Exclude exclude : excludes) {
        //和排除区间没有交集
        if (exclude.start >= right || exclude.end <= left) {
          continue;
        }
        if (exclude.start>left){
          exclude.start=left;
        }
        if (exclude.end<right){
          exclude.end=right;
        }
      }
    }
  }

  class Exclude {

    private int start;
    private int end;

    public Exclude(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
/**
 * Your RangeModule object will be instantiated and called as such: RangeModule obj = new
 * RangeModule(); obj.addRange(left,right); boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
