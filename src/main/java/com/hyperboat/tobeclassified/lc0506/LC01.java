package com.hyperboat.tobeclassified.lc0506;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC01 {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 0, 5, 1, -5, -6, 8, 10, -13, -11, 20, -4, -6, 12, 13};
        System.out.println(Arrays.toString(new LC01().twoSum(ints, 11)));
        System.out.println(new LC01().threeSum(ints));
        System.out.println(new LC01().threeSum2(ints, 5));
        System.out.println(new LC01().fourSum(ints, 5));
    }

    /**
     * show 两数之和
     *
     * @param nums   指定int数组
     * @param target 指定和
     * @return 满足条件的两个数的下标
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //如果存在则返回
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            //不存在则存入
            map.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * show 三数之和（和为0）
     *
     * @param nums 指定数组
     * @return List<List < Integer>> 返回所有组成可能组合
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        //排序,默认升序，它内置的排序算法选择也值得看一看
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> resultArr = new ArrayList<>();
        //存入哈希表
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Integer t;
        int target;
        for (int i = 0; i < nums.length; ++i) {
            target = -nums[i];
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((t = map.get(target - nums[j])) != null) {
                    //符合要求的情况,存入
                    if (t > j) {
                        resultArr.add(new ArrayList<>
                                (Arrays.asList(nums[i], nums[j], nums[t])));
                    } else {
                        break;
                    }
                }
            }
        }
        return resultArr;
    }

    /**
     * @param nums   指定数组
     * @param target 指定和
     * @return List<List < Integer>> 返回所有可能性组合
     */
    public List<List<Integer>> threeSum2(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            /*去重*/
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            /*两个指针，l在最左边，指向最小数，r在右边，指向最大数*/
            int l = i + 1;
            int r = nums.length - 1;
            /*当两指针未碰撞时*/
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                /*当和满足条件时，将其加入list，并根据情况去掉l和r各自重复组合的可能*/
                if (sum == target) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    /*去重l*/
                    while (l < r && nums[l] == nums[l + 1]) {
                        ++l;
                    }
                    /*去重r*/
                    while (l < r && nums[r] == nums[r - 1]) {
                        --r;
                    }
                    /*添加完，两指针各自向中间移动*/
                    ++l;
                    --r;
                    /*和不满足条件时，根据大小情况移动其中一个指针*/
                } else if (sum < target) {
                    ++l;
                } else {
                    --r;
                }
            }
        }
        return result;
    }

    /**
     * show 四数之和
     *
     * @param nums   指定数组
     * @param target 指定和
     * @return List<List < Integer>> 返回所有可能列表
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        //存入
                        arr.add(new ArrayList<>
                                (Arrays.asList(nums[i], nums[j], nums[l], nums[r])));
                        //去重
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return arr;
    }

    /*    *//**
     * show n数之和
     *
     * @param nums   指定数组
     * @param target 指定和
     * @param n      指定数的个数
     * @return 返回所有符合条件的组合
     * [[-13, 5, 13], [-13, 8, 10], [-11, -4, 20], [-6, 1, 10], [-5, 0, 10], [-4, 1, 8]]
     *//*
    public List<List<Integer>> nSum(int[] nums, int target, int n) {
        if (n == 2) {
            int[] ints = twoSum(nums, target);
            List<List<Integer>> res = new ArrayList<>();
            Integer[] integers = new Integer[2];
            integers[0] = ints[0];
            integers[1] = ints[1];
            res.add(Arrays.asList(integers));
            return res;
        }
        if (nums == null || nums.length < n) {
            return new ArrayList<>();
        }
        *//*[-13, -11, -6, -6, -5, -4, 0, 1, 1, 5, 8, 10, 12, 13, 20]*//*
     *//*[-13, -11, -6, -6, -5, -4, 1, 1, 5, 8, 10, 12, 13, 20]*//*
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - n + 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (n > 3) {
                int[] ints = deleteFirst(nums);
                lists = nSum(ints, target - nums[i], n - 1);
                int tempInt = ints[i];
                lists.forEach(integers -> integers.add(tempInt));
            } else {
                *//*两个指针，l在最左边，指向最小数，r在右边，指向最大数*//*
                int l = i + 1;
                int r = nums.length - 1;
                *//*当两指针未碰撞时*//*
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    *//*当和满足条件时，将其加入list，并根据情况去掉l和r各自重复组合的可能*//*
                    if (sum == target) {
                        results.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                        *//*去重l*//*
                        while (l < r && nums[l] == nums[l + 1]) {
                            ++l;
                        }
                        *//*去重r*//*
                        while (l < r && nums[r] == nums[r - 1]) {
                            --r;
                        }
                        *//*添加完，两指针各自向中间移动*//*
                        ++l;
                        --r;
                        *//*和不满足条件时，根据大小情况移动其中一个指针*//*
                    } else if (sum < target) {
                        ++l;
                    } else {
                        --r;
                    }
                }
                return results;
            }
        }
        return lists;
    }

    private int[] deleteFirst(int[] arr) {
        int[] temp = new int[arr.length - 1];
        System.arraycopy(arr, 1, temp, 0, temp.length);
        return temp;
    }*/
}
