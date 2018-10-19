package com.lujj.java8.filter;

import com.lujj.java8.bean.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Client {

    public static void main(String[] args) {
        //旧办法
        List<Apple> apples = getApples();
        List<Apple> result = filterColourApples(apples,"红色");
        System.out.println(result.size());
        //lambda
        result = filterApple(apples,(Apple a) ->"红色".equals(a.getColour()));
        System.out.println(result.size());
        //steam
        result = apples.stream().filter((Apple a) -> "红色".equals(a.getColour())).collect(Collectors.toList());
        System.out.println(result.size());

        //给苹果按重量排序
        result.sort((Apple a,Apple b)->a.getWeight()-b.getWeight());
        System.out.println(result.get(0).getWeight());
        //给苹果按重量排序
        result.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(result.get(0).getWeight());
        //给苹果按重量排序
        result.sort(Comparator.comparing(Apple::getWeight).reversed());//逆序
        System.out.println(result.get(0).getWeight());


    }

    /**
     * 旧方法
     * @param list
     * @param colour
     * @return
     */
    public static List<Apple> filterColourApples(List<Apple> list,String colour){
        List<Apple> result = new ArrayList<>();
        for(Apple a:list){
            if(colour.equals(a.getColour())){
                result.add(a);
            }
        }
        return result;
    }

    public static List<Apple> getApples () {
        List<Apple> list = new ArrayList<Apple>(100);
        Random random = new Random();
        for(int i=0;i<100;i++){
            Apple apple = new Apple();
            apple.setWeight(random.nextInt(200));
            String colour = random.nextInt(2) == 1?"绿色":"红色";
            apple.setColour(colour);
            list.add(apple);
        }
        return list;
    }

    public static List<Apple> filterApple (List<Apple> list,ApplePredicate predicate){
        List<Apple> result = new ArrayList<>();
        for(Apple a:list){
            if(predicate.test(a)){
                result.add(a);
            }
        }
        return result;
    }
}
