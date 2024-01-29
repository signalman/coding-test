package Algorithm.day48;

import java.util.ArrayList;
import java.util.List;

public class P2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] ints = list.stream()
                         .mapToInt(Integer::intValue)
                         .toArray();
    }
}
