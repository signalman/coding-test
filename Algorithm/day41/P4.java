package Algorithm.day41;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        Integer[] arr2 = list.toArray(new Integer[4]);
        System.out.println(list);
    }
}
