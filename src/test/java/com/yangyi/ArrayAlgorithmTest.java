package com.yangyi;

import org.junit.Test;


public class ArrayAlgorithmTest {
    
    @Test
    public void intersect() {
    }
    
    @Test
    public void intersect2() {
        int[] arr1 = new int[]{4, 9, 5};
        int[] arr2 = new int[]{9, 4, 9, 8, 4};
        
        ArrayAlgorithm algorithm = new ArrayAlgorithm();
        
        algorithm.intersect2(arr1, arr2);
    }
}