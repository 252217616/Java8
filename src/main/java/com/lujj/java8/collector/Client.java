package com.lujj.java8.collector;

import com.lujj.java8.bean.Apple;
import com.lujj.java8.filter.FilterClient;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Client {

    public static void main(String[] args) {
        Map<Boolean, List<Integer>> collect = IntStream.rangeClosed(2, 1000).boxed().collect(Collectors.partitioningBy(x -> isPrime(x)));
        System.out.println(111);
    }


    @Test
    public void sum(){
        List<Apple> apples = FilterClient.getApples();
        Integer sum = apples.stream().mapToInt(Apple::getWeight).sum();
        System.out.println(sum);
    }
    @Test
    public void average(){
        List<Apple> apples = FilterClient.getApples();
        OptionalDouble average = apples.stream().mapToInt(Apple::getWeight).average();
        System.out.println(average.getAsDouble());
    }

    /**
     * 连接字符串
     */
    @Test
    public void joining(){
        List<Apple> apples = FilterClient.getApples();
        String collect = apples.stream().map(Apple::getColour).collect(Collectors.joining(","));
        System.out.println(collect);
    }

    /**
     * 分组
     */
    @Test
    public void groupingBy(){
        List<Apple> apples = FilterClient.getApples();
        Map<String, List<Apple>> collect = apples.stream().collect(Collectors.groupingBy(Apple::getColour));
        System.out.println(123);
    }

    /**
     * 去掉Optional的收集器
     */
    @Test
    public void groupingBy2(){
        List<Apple> apples = FilterClient.getApples();
//        apples.stream().collect(Collectors.groupingBy(Apple::getColour,Collectors.collectingAndThen(Collectors.maxBy(Apple::getWeight)),Optional::get));
    }

    /**
     * 分区
     */
    @Test
    public void groupingBy3(){
        List<Apple> apples = FilterClient.getApples();
        Map<Boolean, List<Apple>> collect = apples.stream().collect(Collectors.partitioningBy(a -> a.getWeight() > 100));
        System.out.println(11);
    }

    /**
     * 质数
     */
    @Test
    public static boolean isPrime(int num){
        int limit = (int) Math.sqrt((double)num);
        return IntStream.rangeClosed(2,limit).noneMatch(i->num%i == 0);
    }

    /**
     * 质数
     */
    @Test
    public void zhishu(){
        Map<Boolean, List<Integer>> collect = IntStream.rangeClosed(0, 1000).boxed().collect(Collectors.partitioningBy(x -> isPrime(x)));
        System.out.println(111);
    }






}
