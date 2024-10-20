package com.hyperboat.题单.位运算.异或性质;

/**
 * 1803. 统计异或值在范围内的数对有多少
 *
 * https://leetcode.cn/problems/count-pairs-with-xor-in-a-range/description/
 * */
class LC1803 {
  // 字典树思路: 要获得异或值在区间[low, high]的所有对数;
  // 可以把数值按照顺序，以二进制的形式从高位到低位插入到字典树中，并且记录每个二进制前缀出现的次数;
  // 前缀树中可以获得 <= x的 所有数值的数量，因此可以使用 f(high) - f(low - 1); 获得该区间的值的数量
  // 前置知识：两个数的比较，就要从高到低比较每个二进制位;直到一方为1 一方为0，为1的一方更大，如果到达末尾都一模一样,说明两个数是相同的。

  class Trie { // 字典树结点

    Trie[] child;
    int sum;

    public Trie() { // 初始化Trie结点
      child = new Trie[2]; // 分别记录二进制位的0和1;
      sum = 0; // 记录当前二进制前缀出现了多少次
    }
  }

  private Trie root = null; // 字典树的根;
  private static final int DEPTH = 14; // 字典树最大的深度

  public int countPairs(int[] nums, int low, int high) {
    int ans = 0;
    root = new Trie(); // 给字典树初始化
    // 依次插入每一个数值; 后面插入的数值，就可以和前面的数值比较;
    for (int i = 1; i < nums.length; ++i) {
      insert(nums[i - 1]);
      ans += get(nums[i], high) - get(nums[i], low - 1);
    }
    return ans;
  }

  // 把数字k的二进制形式，按高到低位依次插入到字典树中;
  public void insert(int k) {
    Trie node = this.root; // 获得字典树;
    for (int i = DEPTH; i >= 0; --i) {
      int bit = (k >> i) & 1; // 取数字k的第i个二进制位;
      if (node.child[bit] == null) { // 如果这个位置没有值，就创建一个结点，表示bit这个位出现了
        node.child[bit] = new Trie();
      }
      node = node.child[bit]; // 进入到字典树下一层;
      node.sum++; // 记录当前前缀出现的次数。
    }
  }

  // 此时前缀树中已插入了一些数值，此get函数可获得满足n 与这些数值的异或 <= k的对数;
  // 字典树中的child数组，如果存在值，就代表对应二进制存在; 例如child[0]存在，表示这一层的二进制0是出现过的
  // 注意：sum 保存的是之前出现的二进制的前缀们;
  public int get(int n, int k) {
    int sum = 0; // 记录出现了多少对 异或值 <= k;
    Trie node = this.root; // 获得字典树
    for (int i = DEPTH; i >= 0; --i) { // 从高位往地位取二进制位。
      int bitn = (n >> i) & 1; // 取数值n的第i个二进制位;
      int bitk = (k >> i) & 1; // 取数值k的第i个二进制位;
      if (bitk == 1) {
        // 如果bitk == 1，那么 在字典树中的二进制位只有与bitn相同，才能使二进制的异或等于0
        // 那就看bitn相同的二进制位是否出现过，如果出现过，说明和bitn的异或等于0，小于bitk的1;
        // 记录即可。
        if (node.child[bitn] != null) {
          sum += node.child[bitn].sum;
        }
        // bitn ^ 1，表示与bitn相反的二进制位， 如果与bitn相反的不存在，那就意味着字典树
        // 中没有二进制位能够与bitn异或使得结果等于1，此时n与字典树中的值的异或都小于k;
        if (node.child[bitn ^ 1] == null) {
          return sum;
        }
        node = node.child[bitn ^ 1]; // 否则的话，就继续进入下一层判断;
      } else {
        // 如果字典树中该层的二进制和bitn相同的二进制不存在，就说明不存在异或 == 0，即
        // 不存在 == bitk的情况，那么就可以直接返回了;
        if (node.child[bitn] == null) {
          return sum;
        }
        // 如果存在，继续进入下一层比较。
        node = node.child[bitn];
      }
    }
    sum += node.sum; // 如果字典树中的数值与n的异或，存在等于k的情况，就会来到字典树的末尾；
    return sum;
  }

}
