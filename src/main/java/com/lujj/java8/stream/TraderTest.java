package com.lujj.java8.stream;

import com.lujj.java8.bean.Trader;
import com.lujj.java8.bean.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TraderTest {

    public static void main(String[] args) {
        List<Transaction> list = getList();
//        one(list);
//        two(list);
        three(list);

    }

    public static List<Transaction> getList() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        return transactions;
    }

    /**
     * 找出2011年发生的所有交易，并按交易额排序（从低到高）
     * @param list
     */
    public static void one (List<Transaction> list) {
        List<Transaction> result = list.stream().filter(x -> x.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(123);
    }

    /**
     * 交易员都在哪些城市工作过
     */
    public static void two(List<Transaction> list){
        List<String> collect = list.stream().map(x->x.getTrader().getCity()).distinct().collect(Collectors.toList());
        System.out.println("123");
    }

    /**
     * 查找所有来自于剑桥的交易员并按照姓名排序。
     */
    public static void three(List<Transaction> list){
        List<Trader> collect = list.stream().map(Transaction::getTrader).filter(x -> "Cambridge".equals(x.getCity())).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        System.out.println("123");
    }

    /**
     *返回所有交易员的姓名字符串，按字母顺序排序。
     */
    public static void four(List<Transaction> list){
        String reduce = list.stream().map(x -> x.getTrader().getName()).distinct().sorted().reduce("", (a, b) -> a + b);
    }

    /**
     *有没有交易员是在米兰工作的？
     */
    public static void five(List<Transaction> list){
        list.stream().anyMatch(x ->"Milan".equals(x.getTrader().getCity()));
    }

    /**
     *打印生活在剑桥的交易员的所有交易额
     */
    public static void six(List<Transaction> list){
        list.stream().filter(x-> "Cambridge".equals(x.getTrader().getCity())).map(Transaction::getValue).collect(Collectors.toList());
    }

    /**
     *所有交易中，最高的交易额是多少？
     */
    public static void seven(List<Transaction> list){
        Integer reduce = list.stream().map(Transaction::getValue).reduce(0, Integer::max);//暗含拆装箱成本
        int sum = list.stream().mapToInt(Transaction::getValue).sum();//先转成基本类型的流

    }

    /**
     *所有交易中，最小的交易
     */
    public static void eight(List<Transaction> list){
        list.stream().min(Comparator.comparing(Transaction::getValue));
    }
}
