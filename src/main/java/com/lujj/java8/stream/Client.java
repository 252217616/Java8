package com.lujj.java8.stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {
//        List<Dish> menu = new ArrayList<>();
//        List<String> lowCaloricDishesName = menu.stream().filter(dish -> dish.getCalories()<400).map(Dish::getName).collect(Collectors.toList());
//        List<String> lowCaloricDishesNames = menu.parallelStream().filter(dish -> dish.getCalories()<400).map(Dish::getName).collect(Collectors.toList());
//          List<String> list = new ArrayList<>();
//          list.add("hello");
//          list.add("World");
//        list.stream().map(s -> s.split("")).flatMap(Arrays::stream).forEach(System.out::println);
        List<Integer> number1 = new ArrayList<>();
        List<Integer> number2 = new ArrayList<>();
        number1.add(1);
        number1.add(2);
        number1.add(3);
        number2.add(4);
        number2.add(5);
        List<int[]> collect = number1.stream().flatMap(i -> number2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());
        System.out.println("12");

    }
}
