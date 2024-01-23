package Algorithm.day47;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Imoticons {

    public static void main(String[] args) {
        int num1 = 29;
        int num2 = 514;
        String s = Integer.toBinaryString(29);
        String s1 = Integer.toString(29, 2);
        System.out.println(s);
        System.out.println(s1);
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(list.isEmpty() ? 1 : -1);
        Collections.reverse(list);
        list.stream()
            .mapToInt(i->i)
            .toArray();



    }

}
