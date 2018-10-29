package com.yangyi;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class RedPackAlgorithm {

    public static void main(String[] args) {
        Map<String, BigDecimal> map = new LinkedHashMap<>();
//        map.put("一等奖", BigDecimal.valueOf(1));
//        map.put("二等奖", BigDecimal.valueOf(1));
//        map.put("三等奖", BigDecimal.valueOf(18));
//        map.put("四等奖", BigDecimal.valueOf(180));
//        map.put("五等奖", BigDecimal.valueOf(250));
//        map.put("六等奖", BigDecimal.valueOf(550));
        map.put("一等奖", BigDecimal.valueOf(1));
        map.put("二等奖", BigDecimal.valueOf(999));

        List<BigDecimal> list = new ArrayList<>(map.values());
        List<String> gifts = new ArrayList<>(map.keySet());

        Map<String, AtomicInteger> resultMap = new LinkedHashMap<>();

        for (int i = 0; i < 10000000; i++) {
//            int index = RedPackAlgorithm.discrete(list);
            int index = RedPackAlgorithm.discrete2(list);
            String key = gifts.get(index);
            if (!resultMap.containsKey(key)) {
                resultMap.put(key, new AtomicInteger());
            }
            resultMap.get(key).incrementAndGet();
        }
        for (String key : map.keySet()) {
            System.out.println(key + "==" + resultMap.get(key)+":概率为"+map.get(key));
        }

    }

    private static int discrete(List<BigDecimal> probabilities) {
        BigDecimal[] arr = {BigDecimal.ZERO};
        arr[0] = arr[0].setScale(3, BigDecimal.ROUND_DOWN);
        probabilities.forEach(p -> arr[0] = arr[0].add(p));
        BigDecimal summary = arr[0];
        arr[0] = BigDecimal.ZERO;
        List<BigDecimal> rates = new ArrayList<>();
        probabilities.forEach(p -> {
            arr[0] = arr[0].add(p);
            rates.add(arr[0].divide(summary, 3, BigDecimal.ROUND_DOWN));
        });
        BigDecimal random = new BigDecimal(Math.random()).setScale(3, BigDecimal.ROUND_DOWN);
        rates.add(random);
        rates.sort(BigDecimal::compareTo);
        return rates.indexOf(random);
    }

    public static int discrete2(List<BigDecimal> probabilities) {
        //  计算概率总和

        BigDecimal[] arr = {BigDecimal.ZERO.setScale(3, BigDecimal.ROUND_DOWN)};
        probabilities.forEach(p -> arr[0] = arr[0].add(p));
        //  转换为双精度制
        List<Double> rates = new ArrayList<>();
        for (BigDecimal p : probabilities) {
            rates.add(p.divide(arr[0], 3, BigDecimal.ROUND_DOWN).doubleValue());
        }
        //  probability用于存放进行概率补齐后各部分剩下的值
        double[] probability = new double[rates.size()];
        //  alias用于存放其他列补足的本列对应概率的下标，无补足时为null
        int[] alias = new int[rates.size()];

        //  计算概率平均数

        final double average = 1.0 / rates.size();

        //  构造两个数组,分别存放大于和小于平均概率的概率下标

        Deque<Integer> small = new ArrayDeque<>();
        Deque<Integer> large = new ArrayDeque<>();
        for (int i = 0; i < rates.size(); ++i) {
            if (rates.get(i) >= average) {
                large.add(i);
            } else {
                small.add(i);
            }
        }

        /**
         *  说明：将小于average的small中指向rates对应下标的概率补齐至average，
         *        补齐部分从large中指向rates对应下标的元素减除
         *  注意：在最终每列满足平均概率的列中，每列只能至多包含两个部分
         *        即原概率和其他任意一部分补齐的概率
         *  定义：小于average的原始概率定义为：small概率，大于average的原始概率定义为：large概率
         */
        while (!small.isEmpty() && !large.isEmpty()) {
            int less = small.removeLast();
            int more = large.removeLast();

            //  small概率进行概率补齐后的概率 = 原始概率*概率数组长度

            probability[less] = rates.get(less) * rates.size();

            //  将要补足给small中对应概率的index放入alias中

            alias[less] = more;

            //  改变large概率在rates原始概率数组中的值，方便下一个循环的概率补齐操作
            rates.set(more,
                (rates.get(more) + rates.get(less)) - average);

            //  判断进行概率补齐后，large概率是否大于average
            if (rates.get(more) >= average) {
                large.add(more);
            } else {
                small.add(more);
            }
        }

        //  按照这种方法补齐，即在probability中始终存在进行上述补齐后始终大于average的数

        while (!small.isEmpty()) {
            probability[small.removeLast()] = 1.0;
        }
        while (!large.isEmpty()) {
            probability[large.removeLast()] = 1.0;
        }
        //  产生两个随机数，并进行采样
        int column = new Random().nextInt(probability.length);

        return Math.random() < probability[column] ? column : alias[column];
    }

}
