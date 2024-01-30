package Algorithm.day48;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class P2 {

    public class Node{
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
            
            
    }
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        int[] ints = list.stream()
//                         .mapToInt(Integer::intValue)
//                         .toArray();
        Set<Node> set = new HashSet<>();
        int x = set.stream()
                   .min(Comparator.comparingLong(o -> o.x))
                   .get().x;
        Node max = Collections.max(set, Comparator.comparingLong(o -> o.x));
        long a = 100000* 100000 - 123;
        System.out.println(a);
    }
}
