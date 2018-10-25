package com.lujj.java8.stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        //通过值来创建stream
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7);
        integerStream.forEach(System.out::println);
        //创建空的流
        Stream<Object> empty = Stream.empty();
        //从数组创建流
        int [] nums = new int[]{1,2,3,4,5,6,7,8};
        IntStream stream = Arrays.stream(nums);
        stream.forEach(System.out::println);

        //从文件读取流
        try (Stream<String> lines = Files.lines(Paths.get("D:\\123.txt"), Charset.defaultCharset())){
            long count = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();//不同的单词数
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 无限流
     */
    @Test
    public void test(){
        Stream.iterate(0,n->n+2).limit(10).forEach(System.out::println);
    }

    @Test
    public void 斐波纳契元组序列(){
        Stream.iterate(new int[]{0,1},n -> new int[]{n[1],n[0]+n[1]}).limit(20).forEach(t -> System.out.print(t[0]+" "));

    }

    /**
     * 第二种创建方式
     */
    @Test
    public void test2(){
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    @Test
    public void 斐波纳契元组序列2(){
        IntStream.generate(new IntSupplier() {
            private int previous =0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous+this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        }).limit(10).forEach(System.out::println);

    }
}
