package Algorithm.day41;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1 {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(2, new ArrayList<>());
        map.get(2).add(3);
        map.get(2).add(3);
        map.get(2).add(3);
        System.out.println(map.get(2));
    }

}
