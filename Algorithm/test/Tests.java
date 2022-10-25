package Algorithm.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tests {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(2);
        arr.add(1);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(4);
        arr.stream().sorted().distinct().forEach(System.out::println);
        Integer reduce = arr.stream().filter(i -> i % 2 == 0).reduce(3, (a, b) -> a + b);
        System.out.println("reduce: " + reduce);
        arr.stream().collect(Collectors.toList());
        arr.stream().collect(Collectors.counting());


    }
}
