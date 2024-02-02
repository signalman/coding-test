package Algorithm.day49;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TET {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 3, 3, 4, 5);
        int i = Collections.binarySearch(list, 6);
        double a = 2.5;
        double floor = Math.floor(a);
        System.out.println(~i);
    }
}
