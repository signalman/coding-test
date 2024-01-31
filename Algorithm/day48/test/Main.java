package Algorithm.day48.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Dog()};

        for (Animal animal : animals) {
            animal.getSounds();
        }
        Set<String> set = new HashSet<>();
        String[] st = new String[3];
        List<String> list = new ArrayList<>();
        List<String> list1 = Arrays.asList("h", "i", "b");
        List<String> list2 = Arrays.asList("h", "b", "i");
        String a = "elkfje";
        if (list2.equals(list1)) {
            System.out.println("FEFEF");
        }
        Animal[] animals1 = Arrays.copyOf(animals, 2);
        boolean contains = "eifha;ef".contains("");
        System.out.println(contains);
        int asInt = Arrays.stream(new int[]{1, 2, 3})
                          .max()
                          .getAsInt();
    }
}
