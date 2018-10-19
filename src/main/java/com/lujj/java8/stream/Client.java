package com.lujj.java8.stream;

import com.lujj.java8.bean.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
//        List<Dish> menu = new ArrayList<>();
//        List<String> lowCaloricDishesName = menu.stream().filter(dish -> dish.getCalories()<400).map(Dish::getName).collect(Collectors.toList());
//        List<String> lowCaloricDishesNames = menu.parallelStream().filter(dish -> dish.getCalories()<400).map(Dish::getName).collect(Collectors.toList());
          List<Integer> list = new ArrayList<>();
          list.add(1);
          list.add(2);
          list.add(3);
          list.add(4);
        list.stream().map(x -> x *= x).forEach(System.out::println);



    }
}
