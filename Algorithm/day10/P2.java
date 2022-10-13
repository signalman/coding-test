package Algorithm.day10;

import java.util.ArrayList;
import java.util.LinkedList;

public class P2 {
    static LinkedList q[] = new LinkedList[10];
    public static void main(String[] args) {

        for(int i=0; i<q.length; i++) q[i] = new LinkedList<>();
        for(int i=0; i<10; i++){
            q[i].offer(2);
        }
    }

}
