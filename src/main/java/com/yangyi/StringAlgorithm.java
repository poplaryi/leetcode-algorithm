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
    
    /**
     * 颠倒整数
     */
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        String numStr = x + "";
        
        String sign = "";
        
        String temp = "";
        
        String[] arr = numStr.split("");
        
        for (int i = arr.length - 1; i >= 0; i--) {
            if (("0").equals(arr[i]) && i == arr.length - 1) {
                continue;
            }
            if (("-").equals(arr[i])) {
                sign = "-";
                continue;
            }
            temp += arr[i];
        }
        
        temp = sign + temp;
        
        int num = 0;
        try {
            num = Integer.parseInt(temp);
        } catch (RuntimeException e) {
            num = 0;
        } finally {
            return num;
        }
    }
    
    public int firstUniqChar(String s) {
        if (s.length() == 0 || s.equals("") || s == null) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            if (i == arr.length - 1) {
                return -1;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
