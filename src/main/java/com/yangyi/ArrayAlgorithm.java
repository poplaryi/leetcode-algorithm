package com.yangyi;

import java.util.*;

/**
 * @Description
 * @Author kcyangyi@gmail.com
 * @Time 2018/10/9 12:40
 */
public class ArrayAlgorithm {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        Arrays.stream(nums1).forEach(m -> list1.add(m));
        
        List<Integer> list2 = new ArrayList<>();
        Arrays.stream(nums2).forEach(n -> list2.add(n));
        
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
     * 两个数组的交集Ⅱ（通过）
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> v1 = new ArrayList<>();
        Arrays.stream(nums1).forEach(i -> v1.add(i));
        
        List<Integer> temp = new ArrayList<>();
        Arrays.stream(nums2).forEach(i -> {
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
     * 加一（通过）
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
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
            }else {
                ++i;
            }
        }
    }
    
    /**
     * 两数之和（通过）
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
}
