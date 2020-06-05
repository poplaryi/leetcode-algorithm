package com.yangyi;

import com.yangyi.code.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayAlgorithm {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        Arrays.stream(nums1)
                .forEach(m -> list1.add(m));

        List<Integer> list2 = new ArrayList<>();
        Arrays.stream(nums2)
                .forEach(n -> list2.add(n));

        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            if (list2.contains(list1.get(i))) {
                list2.remove(list1.get(i));
                temp.add(list1.remove(i));
            }
        }

        int[] arr = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            arr[i] = temp.get(i);
        }
        return arr;
    }

    /**
     * 从排序数组中删除重复项
     */
    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(nums)
                .forEach(n -> {
                    if (!list.contains(n)) {
                        list.add(n);
                        nums[list.indexOf(n)] = n;
                    }
                });
        return list.size();
    }

    /**
     * 存在重复
     */
    public boolean containsDuplicate(int[] nums) {
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        Map<Integer, Boolean> map = new HashMap<>();
        for (int n : list) {
            if (map.get(n) != null) {
                return true;
            }
            map.put(n, true);
        }
        return false;
    }

    /**
     * 只出现一次的数字
     */
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(nums)
                .forEach(num -> {
                    if (list.contains(num)) {
                        list.remove(new Integer(num));
                    } else {
                        list.add(num);
                    }
                });
        return list.get(0);
    }

    /**
     * 两个数组的交集Ⅱ
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> v1 = new ArrayList<>();
        Arrays.stream(nums1)
                .forEach(i -> v1.add(i));

        List<Integer> temp = new ArrayList<>();
        Arrays.stream(nums2)
                .forEach(i -> {
                    if (v1.contains(i)) {
                        v1.remove(new Integer(i));
                        temp.add(i);
                    }
                });

        int[] arr = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            arr[i] = temp.get(i);
        }
        return arr;
    }

    /**
     * 加一
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            if (digits[i] < 10) {
                break;
            }
            if (i == 0) {
                digits = new int[digits.length + 1];
                digits[0] = 1;
                return digits;
            }
            digits[i] = 0;
        }
        return digits;
    }

    /**
     * 移动零
     */
    public void moveZeroes(int[] nums) {
        int index = nums.length - 1;
        for (int i = 0; i <= index; ) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
                --index;
            } else {
                ++i;
            }
        }
    }

    /**
     * 两数之和
     */
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }

    /**
     * 有效的数独
     */
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        Set<Character> temp = new HashSet<>();
        for (int i = 0; i < len; i++) {
            char[] arr = board[i];
            if (temp.contains(arr[i])) {
                return false;
            }
            temp.add(arr[i]);
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    return false;
                }
                set.add(arr[j]);
            }
        }
        return true;
    }

    /**
     * 旋转数组
     */
    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k - nums.length;
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        List<Integer> temp = new LinkedList<>();
        temp.addAll(list.subList(list.size() - k, list.size()));
        temp.addAll(list.subList(0, list.size() - k));
        for (int i = 0; i < temp.size(); i++) {
            nums[i] = temp.get(i);
            System.out.println(temp.get(i));
        }
    }

    /**
     * 买卖股票的最佳时机
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int indexTemp = 0;
        for (int i = 0; i < prices.length; ) {
            int profitTemp = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    int temp = prices[j] - prices[i];
                    if (profitTemp < temp) {
                        profitTemp = temp;
                        indexTemp = j;
                    }
                }
            }
            profit += profitTemp;
            i = ++indexTemp;
        }
        return profit;
    }

    /**
     * 实现strStr()
     */
    public int strStr(String haystack, String needle) {
        if (Objects.isNull(needle)) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }
        return -1;
    }


}
