package com.yangyi;

import java.util.*;

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
    
    /**
     * 有效的字母异位词
     */
    public boolean isAnagram(String s, String t) {
        final Boolean[] flag = {true};
        
        if(s.equals(t)) {
            flag[0] = true;
        }
        Map<String,Integer> map = new HashMap<>();
        
        Arrays.stream(s.split("")).forEach(a-> {
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else{
                map.put(a,1);
            }
        });
        Map<String,Integer> temp = new HashMap<>();
        Arrays.stream(t.split("")).forEach(b->{
            if(!map.containsKey(b)){
                flag[0] = false;
            }
            if(temp.containsKey(b)){
                temp.put(b,temp.get(b)+1);
            }else{
                temp.put(b,1);
            }
        });
        
        map.forEach((k,v) ->{
            if(temp.get(k) != v){
                flag[0] = false;
            }
        });
        if(s.length() != t.length()){
            flag[0] = false;
        }
        return flag[0];
    }
    
}
