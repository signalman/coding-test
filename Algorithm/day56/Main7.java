package Algorithm.day56;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main7 {

    static class Node{
        int x = 1; int y = 1;
        int score;
        Node(){
            this.score = 5;
        }
        Node(int x, int y) {
            this();
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Node[] nodes = new Node[10];
        for(int i=0; i<10; i++){
            nodes[i] = new Node(i, i + 2);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.score));
        for(int i=0; i<10; i++){
            pq.add(nodes[i]);
        }
        nodes[4].score = -1;
        while (!pq.isEmpty()) {
            System.out.println(pq.poll().score);
        }
    }

}
