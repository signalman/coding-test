package Algorithm.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tests {
    public static void main(String[] args) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', map.getOrDefault('A', 0) + 3);
        map.put('A', map.getOrDefault('A', 0) + 3);
        map.put('A', map.getOrDefault('A', 0) + 3);
        System.out.println(map.get('A'));

    }
}
