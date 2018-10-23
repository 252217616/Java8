package com.lujj.java8.boxed;

import com.lujj.java8.bean.Dish;
import com.lujj.java8.bean.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {
        List<Transaction> list = new ArrayList<>();
        //免除拆装箱成本
        IntStream intStream = list.stream().mapToInt(Transaction::getValue);
        //转回包装流
        Stream<Integer> boxed = intStream.boxed();

        //生成1-100所有的数
        IntStream intStream1 = IntStream.rangeClosed(0, 100).filter(x -> x % 2 == 0);//所有的偶数
        System.out.println(intStream1.count());

        //生成1-100以内的勾股数
        IntStream.rangeClosed(0,100).boxed().flatMap(a -> IntStream.rangeClosed(a,100)
                .filter(b -> Math.sqrt(a*a+b*b)%1==0).mapToObj(b ->new int[] {a,b,(int) Math.sqrt(a*a+b*b)}));

    }
}
