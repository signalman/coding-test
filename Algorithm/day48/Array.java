package Algorithm.day48;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Array {

    class Node{
        int x, y;

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Node n = (Node) obj;
            return this.x == n.x && this.y == n.y;
        }
    }
/*
* int[] 를
* String replaceAll()
* String.format()
*
* 글자 갯수만큼 붙이기
* char[] -> String
* String -> char[]
* StringBuilder -> String
* StringBuilder 제거, 갯수만큼 붙이기
*
* Collections
* Map, Set 함수
* int[] -> LIst<Integer>
*
* */
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 1, 2, 7};
        List<Integer> list = Arrays.stream(array).boxed().toList();
        String s1 = String.copyValueOf(new char[]{'h', 'i'});

        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 2);
        System.out.println(map.size());
        map.remove(2);
        String name = "ehll";
        String ll = name.replaceAll("ll", "");
        System.out.println(ll);
        String format = String.format("%-11s", ll);
        char[] chars = new char[]{'c', 'h', 'a', 'a', 'a', 't'};
        String s = String.valueOf(chars);
        s = s.replaceAll("a", "");
        StringBuilder sb = new StringBuilder("abc");


        System.out.println(s);

    }
}
