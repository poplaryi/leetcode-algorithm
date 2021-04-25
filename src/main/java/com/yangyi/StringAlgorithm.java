package com.yangyi;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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
        if ("".equals(s) || s == null) {
            return -1;
        }
        String[] arr = s.split("");
        Map<String, Integer> map = new LinkedHashMap<>();
        Arrays.stream(arr).forEach(r -> {
            if (map.containsKey(r)) {
                map.put(r, map.get(r) + 1);
            } else {
                map.put(r, 1);
            }
        });
        final String[] temp = {""};
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() <= 1) {
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
        Map<String, AtomicInteger> map = new HashMap<>();

        Arrays.stream(s.split("")).forEach(a -> {
            if (map.containsKey(a)) {
                map.get(a).incrementAndGet();
            } else {
                map.put(a, new AtomicInteger());
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

    /**
     * 验证回文字符串
     */
    public boolean isPalindrome(String s) {
        if (s.length() <= 1 || !s.matches(".*[a-zA-z0-9]+.*")) {
            return true;
        }
        int temp = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = temp; j >= 0; j--) {
                if (i == j) {
                    return true;
                }
                String a = String.valueOf(s.charAt(i));
                if (!a.matches("[a-zA-z0-9]") || a.equals("`")) {
                    break;
                }
                String b = String.valueOf(s.charAt(j));
                if (!b.matches("[a-zA-z0-9]") || b.equals("`")) {
                    temp--;
                    continue;
                }
                if (!String.valueOf(s.charAt(i)).toUpperCase()
                        .equals(String.valueOf(s.charAt(j)).toUpperCase())) {
                    return false;
                }
                temp--;
                break;
            }
        }
        return true;
    }

    /**
     * 字符串转整数
     */
    public int myAtoi(String str) {
        String sign = "+";
        long temp;
        String num = "";
        str = str.replace(" ", "");
        if ("".equals(str) || str == null) {
            return 0;
        }
        if (!String.valueOf(str.charAt(0)).matches("[0-9]")
                && !"+".equals(String.valueOf(str.charAt(0)))
                && !"-".equals(String.valueOf(str.charAt(0)))) {
            return 0;
        }
        if ("-".equals(String.valueOf(str.charAt(0)))) {
            sign = "-";
            str = str.substring(1);
        } else if ("+".equals(String.valueOf(str.charAt(0)))) {
            str = str.substring(1);
        }
        if ("".equals(str)) {
            return 0;
        }
        boolean flag = true;
        do {
            if (str.length() > 0 && "0".equals(String.valueOf(str.charAt(0)))) {
                str = str.substring(1);
            } else {
                flag = false;
            }
        } while (flag);
        for (int i = 0; i < str.length(); i++) {
            if (!" ".equals(String.valueOf(str.charAt(i)))) {
                if (String.valueOf(str.charAt(i)).matches("[0-9]")) {
                    num += str.charAt(i);
                    continue;
                }
                break;
            }
        }
        if (num != null && !"".equals(num)) {
            if (num.length() > 10) {
                if ("-".equals(sign)) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            temp = Long.parseLong(num);
            if ("-".equals(sign)) {
                temp = temp * -1;
            }
            if (temp >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (temp <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return new Long(temp).intValue();
            }
        }
        return 0;
    }

    /**
     * 罗马数字转整数
     */
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            int num = getValue((s.charAt(i)));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        if (s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']') {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (!isCoupleSymbol(stack.pop(), c)) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isCoupleSymbol(char i, char j) {
        if (i == '{' && j == '}') {
            return true;
        } else if (i == '[' && j == ']') {
            return true;
        } else return i == '(' && j == ')';
    }
}
