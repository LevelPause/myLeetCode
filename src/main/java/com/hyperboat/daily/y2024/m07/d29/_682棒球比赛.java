package com.hyperboat.daily.y2024.m07.d29;

import java.util.ArrayList;
import java.util.List;

public class _682棒球比赛 {

  public int calPoints(String[] operations) {
    List<Integer> scores = new ArrayList<>();
    int res = 0;
    for (String operation : operations) {
      int size = scores.size();
      int newScore;
      switch (operation) {
        case "+":
          newScore = scores.get(size - 1) + scores.get(size - 2);
          scores.add(newScore);
          break;
        case "D":
          newScore = scores.get(size - 1) * 2;
          scores.add(newScore);
          break;
        case "C":
          newScore = -scores.remove(size - 1);
          break;
        default:
          newScore = Integer.parseInt(operation);
          scores.add(newScore);
      }
      res += newScore;
    }
    return res;
  }
}
