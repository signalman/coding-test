package Algorithm.day49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solve {

    public static void main(String[] args) {
        double a = 1.12345;
        double v = a - (int) a;

        long l = Long.MAX_VALUE;
        long max = Math.max(l, 12312);
        List<Integer> list = new ArrayList<>();
        int frequency = Collections.frequency(list, 23);
        System.out.println(frequency);
        int asInt = Arrays.stream(new int[]{1, 2, 2, 13})
                          .max()
                          .getAsInt();



        System.out.println(v);
    }
}
