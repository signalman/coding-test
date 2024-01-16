package Algorithm.day46;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.vm.name"));
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(21);
        int[] arr = list.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
