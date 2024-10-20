package com.hyperboat.daily.y2024.m08.d26;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LC690 {

  class Employee {

    public int id;
    public int importance;
    public List<Integer> subordinates;
  }


  class Solution {

    private Map<Integer, Employee> map;

    public int getImportance(List<Employee> employees, int id) {
      Employee leader = null;
      map = new HashMap<>();
      for (Employee employee : employees) {
        if (employee.id == id) {
          leader = employee;
        }
        map.put(employee.id, employee);
      }
      return dfs(leader);
    }

    public int dfs(Employee emp) {
      if (emp == null) {
        return 0;
      }
      int value = emp.importance;
      for (Integer subordinate : emp.subordinates) {
        value += dfs(map.get(subordinate));
      }
      return value;
    }
  }
}
