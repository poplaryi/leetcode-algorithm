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

    /**
     * 找到第一个不重复的字符
     */
    public int firstUniqChar(String s) {
        String[] arr = s.split("");
        Map<String, Integer> map = new LinkedHashMap<>();
        Arrays.stream(arr).forEach(r -> {
            if (map.containsKey(r)) {
                map.put(r, map.get(r) + 1);
            }else{
                map.put(r, 1);
            }
        });
        final String[] temp = {""};
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() <= 1){
                temp[0] = entry.getKey();
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(temp[0])) {
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

        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<String, Integer> map = new HashMap<>();

        Arrays.stream(s.split("")).forEach(a -> {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        });
        Map<String, Integer> temp = new HashMap<>();

        Arrays.stream(t.split("")).forEach(b -> {
            if (!map.containsKey(b)) {
                flag[0] = false;
            }
            if (temp.containsKey(b)) {
                temp.put(b, temp.get(b) + 1);
            } else {
                temp.put(b, 1);
            }
        });

        map.forEach((k, v) -> {
            if (temp.containsKey(k) && !temp.get(k).equals(v)) {
                flag[0] = false;
            }
        });

        return flag[0];
    }

}
