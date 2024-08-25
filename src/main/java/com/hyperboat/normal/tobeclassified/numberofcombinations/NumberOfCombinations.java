package com.hyperboat.normal.tobeclassified.numberofcombinations;


/**
 * @author hyperboat
 * @date 2022年03月16日 10:11
 * <p>
 * 你写下了若干正整数，并将它们连接成了一个字符串num。但是你忘记给这些数字之间加逗号了。你只记得这一列数字是非递减的且没有 任何数字有前导 0 。
 * <p>
 * 请你返回有多少种可能的 正整数数组可以得到字符串num。由于答案可能很大，将结果对 109 + 7取余后返回。
 */
public class NumberOfCombinations {

  private int result;

  public int numberOfCombinations(String num) {
    if (num.charAt(0) == '0') {
      return 0;
    }
    result = 0;
    dfs(num);
    return result / 1000_000_007;
  }

  private void dfs(String num) {
    int currNum = Integer.parseInt(num.substring(0, 1));

  }
}
