package Algorithm.day55;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;

public class Main12 {
    private static class Node{
        int x, y;
    }

    public static void main(String[] args) {
        Dictionary<String, String> d = new Hashtable<>();
        Map<Integer, String> map = new HashMap<>(123, 0.75f);

        int i = Integer.valueOf(3).hashCode();
        int i1 = Double.valueOf(2.2)
                       .hashCode();
        long l = Double.doubleToLongBits(2.123);
        Objects.hashCode(Integer.valueOf(123));
        int hash = Objects.hash(1, 2, 3);
        int h = Objects.hashCode(new int[]{1, 2, 3});
        System.out.println(hash + " " + h);

        map.putAll(Map.of(6, "six", 12, "twelve", 1, "one", 2, "two"
//            ,3, "three", 4, "four"
        ));
        Node n = new Node();
        String name = n.getClass()
                       .getName();
        System.out.println(name);
        String name1 = n.getClass()
                       .getName();
        System.out.println(name1);

        for (Integer integer : map.keySet()) {
            System.out.println(integer + " " + map.get(integer));
        }
        String str = "";
        str.hashCode();
    }


}
