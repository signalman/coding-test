package Algorithm.day49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TET {

    public static void main(String[] args) {

        int[] array = new int[5];
        List<Integer> list = Arrays.stream(array)
                                   .boxed()
                                   .toList();
        List<String> strings = new ArrayList<>();
        String[] array1 = strings.toArray(new String[0]);
    }
}
