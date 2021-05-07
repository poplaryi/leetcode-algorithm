package com.yangyi;


import com.yangyi.code.algorithm.ArrayAlgorithm;
import com.yangyi.code.spi.Search;
import org.junit.Test;

import java.util.ServiceLoader;

public class ArrayAlgorithmTest {

    @Test
    public void intersect() {
    }

    @Test
    public void intersect2() {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        ArrayAlgorithm algorithm = new ArrayAlgorithm();

        algorithm.rotate(arr1, 11);

    }

    @Test
    public void maxProfitTest() {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        ArrayAlgorithm arrayAlgorithm = new ArrayAlgorithm();
        int i = arrayAlgorithm.maxProfit(arr);
        System.out.println(i);
    }


    @Test
    public void delItemTest() {
        int[] arr = new int[]{1, 2, 2, 1};

        ArrayAlgorithm algorithm = new ArrayAlgorithm();

        int i = algorithm.removeElement(arr, 1);

        System.out.println(i);
    }

    @Test
    public void nextGreaterElementTest() {
        int[] nums1 = new int[]{2, 4};
        int[] nums2 = new int[]{1, 2, 3, 4};
        ArrayAlgorithm algorithm = new ArrayAlgorithm();
        int[] ints = algorithm.nextGreaterElement(nums1, nums2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    @Test
    public void calPointsTest() {
        String[] nums1 = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
        ArrayAlgorithm algorithm = new ArrayAlgorithm();
        System.out.println(algorithm.calPoints(nums1));
    }

    @Test
    public void backspaceCompareTest() {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        ArrayAlgorithm algorithm = new ArrayAlgorithm();
        System.out.println(algorithm.backspaceCompare(s, t));
    }

    @Test
    public void removeOuterParenthesesTest() {
        String s = "(()())(())(()(()))";
        ArrayAlgorithm algorithm = new ArrayAlgorithm();
        System.out.println(algorithm.removeOuterParentheses(s));
    }

    @Test
    public void test() {
        int COUNT_BITS = Integer.SIZE - 3;
        int RUNNING = -1 << COUNT_BITS;
        int SHUTDOWN = 0 << COUNT_BITS;
        int STOP = 1 << COUNT_BITS;
        int TIDYING = 2 << COUNT_BITS;
        int TERMINATED = 3 << COUNT_BITS;
        int capacity = (1 << COUNT_BITS) - 1;
        System.out.println(RUNNING);
        System.out.println(SHUTDOWN);
        System.out.println(STOP);
        System.out.println(TIDYING);
        System.out.println(TERMINATED);
        System.out.println(capacity);
    }

    @Test
    public void testCase() {
        ServiceLoader<Search> load = ServiceLoader.load(Search.class);
        for (Search next : load) {
            next.searchDoc("hello");
        }
    }
}