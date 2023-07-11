package Algorithm.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
    static class Node{
        int x,y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Node p) {
            if (this.y < p.x) {
                return -1;
            } else if (this.y == p.y) {
                if (this.x < p.x) {
                    return -1;
                }
            }
            return 1;
        }
    }
    public static void main(String[] args) {
        String str = "hi my name is hoin";
        String[] nee = str.split(" ");

        for (String s : nee) {
            System.out.println(s);
        }
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<10; i++){
            pqMin.offer(i);
            pqMax.offer(i);
        }
        System.out.println(pqMin.poll());
        System.out.println(pqMax.poll());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        String[] arr = {"hihi", "ddd", "eee"};
        System.out.println(Arrays.toString(arr));

        String ss = "helllooo";
        for(int i=0; i<10; i++){
            ss = ss + "x";
        }
        System.out.println(ss);

    }

}
