package com.lujj.java8.Optional;

import com.lujj.java8.bean.Dish;

import java.util.*;

public class Client {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        Optional<Integer> any = list.stream().filter(i -> i < 10).findAny();
//        any.isPresent();//false
//        any.ifPresent(System.out::println);
//        Integer integer = any.get();
//        any.orElse(1);
//        first3();
        //计算总菜品热量
        List<Dish> dishs = getDishs();
        int x = 0;
        for(Dish d : dishs){
            x = x +d.getCalories();
        }
        System.out.println(x);
        //新方法
        Integer reduce = dishs.stream().map(Dish::getCalories).reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
    }

    /**
     * 找到第一被3整除的数的平方
     */
    public static void first3(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
//        Optional<Integer> first = list.stream().map(x -> x * x).filter(x -> x % 3 == 0).findFirst();
        Optional<Integer> first = list.stream().map(x -> x * x).filter(x -> x % 3 == 0).findAny();
        System.out.println(first.orElse(0));
    }

    /**
     * 随机获得100道菜
     */
    public static List<Dish> getDishs(){
        Random random = new Random();
        List<Dish> result = new ArrayList<Dish>(100);
        for(int i=0;i<100;i++){
            Dish d = new Dish();
            d.setCalories(random.nextInt(2000));
            d.setName(i+"号菜品");
            result.add(d);
        }
        return result;
    }
}
