package com.yangyi;


import org.junit.Test;

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


}