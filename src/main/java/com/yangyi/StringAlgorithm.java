package com.yangyi;

public class StringAlgorithm {
    /**
     * 反转字符串
     */
    public String reverseString(String s) {
        StringBuilder temp = new StringBuilder();
        String[] arr = s.split("");
        for (int i = arr.length - 1; i >= 0; i--) {
            temp.append(arr[i]);
        }
        return temp.toString();
    }
}
