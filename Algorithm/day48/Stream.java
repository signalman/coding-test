package Algorithm.day48;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stream {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        Integer integer = list.stream()
                              .max(Comparator.naturalOrder())
                              .get();

        System.out.println(integer);

    }




}
